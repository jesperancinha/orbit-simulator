package org.jesperancinha.orbitsimulator.threads;

import org.jesperancinha.orbitsimulator.manager.InertiaManager;
import org.jesperancinha.orbitsimulator.objects.Inertia;
import org.jesperancinha.orbitsimulator.objects.Planet;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by joaofilipesabinoesperancinha on 09-04-16.
 */
public class ActivityManagerImplTest {
    final static Mockery mockery = new Mockery();

    @Test
    public void startRace() throws Exception {
        final InertiaManager driverManager = mockery.mock(InertiaManager.class);
        final Inertia inertia = mockery.mock(Inertia.class);
        final Planet planet = mockery.mock(Planet.class);
        final ExecutorService executorService= mockery.mock(ExecutorService.class);
        final Map<Integer,Inertia> inertias = new HashMap<>();
        final Future<Planet> futurePlanet = mockery.mock(Future.class);
        final Callable<Planet> callabalePlanet = mockery.mock(Callable.class);
        inertias.put(0, inertia);


        mockery.checking(new Expectations(){{
            oneOf(driverManager).getDriverList();
            will(returnValue(inertias));

            oneOf(executorService).submit(callabalePlanet);
            will(returnValue(futurePlanet));

            oneOf(inertia).getPlanet();
            will(returnValue(planet));

            oneOf(planet).startRacing();
            will(returnValue(callabalePlanet));

            oneOf(futurePlanet).get();
            will(returnValue(planet));

            oneOf(planet).isSuccess();
            will(returnValue(true));

            oneOf(executorService).shutdown();

            oneOf(executorService).awaitTermination(60, TimeUnit.SECONDS);

            oneOf(executorService).isTerminated();
            will(returnValue(true));

            oneOf(executorService).shutdownNow();
        }});

        final ActivityManager activityManager= new ActivityManagerImpl(driverManager)
        {
            @Override
            public ExecutorService getExecutorService(Collection<Inertia> drivers) {
                return executorService;
            }
        };
        
        activityManager.startRace();
    }

}
