package com.jfse.kartracelaps.threads;

import com.jfse.kartracelaps.manager.DriverManager;
import com.jfse.kartracelaps.objects.Driver;
import com.jfse.kartracelaps.objects.Kart;
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
        final DriverManager driverManager = mockery.mock(DriverManager.class);
        final Driver driver = mockery.mock(Driver.class);
        final Kart kart = mockery.mock(Kart.class);
        final ExecutorService executorService= mockery.mock(ExecutorService.class);
        final Map<Integer,Driver> drivers = new HashMap<>();
        final Future<Kart> futureKart = mockery.mock(Future.class);
        final Callable<Kart> callabaleKart = mockery.mock(Callable.class);
        drivers.put(0, driver);


        mockery.checking(new Expectations(){{
            oneOf(driverManager).getDriverList();
            will(returnValue(drivers));

            oneOf(executorService).submit(callabaleKart);
            will(returnValue(futureKart));

            oneOf(driver).getKart();
            will(returnValue(kart));

            oneOf(kart).startRacing();
            will(returnValue(callabaleKart));

            oneOf(futureKart).get();
            will(returnValue(kart));

            oneOf(kart).isSuccess();
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
            public ExecutorService getExecutorService(Collection<Driver> drivers) {
                return executorService;
            }
        };
        
        activityManager.startRace();
    }

}