package com.steelzack.orbitsimulator.threads;

import com.steelzack.orbitsimulator.exceptions.PlanetOutOfOrbitException;
import com.steelzack.orbitsimulator.manager.InertiaManager;
import com.steelzack.orbitsimulator.objects.Inertia;
import com.steelzack.orbitsimulator.objects.Planet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by joaofilipesabinoesperancinha on 09-04-16.
 */
public class ActivityManagerImpl implements ActivityManager {
    private final InertiaManager driverManager;
    private boolean startRace = false;

    public ActivityManagerImpl(InertiaManager driverManager) {
        this.driverManager = driverManager;
    }

    @Override
    public void startRace() throws ExecutionException, InterruptedException, PlanetOutOfOrbitException {
        startRace = true;
        final Collection<Inertia> drivers = driverManager.getDriverList().values();
        List<Future<Planet>> allDriverWaiter = new ArrayList<>();
        final ExecutorService executor = getExecutorService(drivers);

        for (Inertia driver : drivers) {
            Future<Planet> future = executor.submit(driver.getPlanet().startRacing());
            allDriverWaiter.add(future);
        }

        for (Future<Planet> future : allDriverWaiter) {
            Planet planet = future.get();
            if (!planet.isSuccess()) {
                throw new PlanetOutOfOrbitException(planet.getPlanetId());
            }
        }
        shutDownExecutorService(executor);
    }

    @Override
    public ExecutorService getExecutorService(Collection<Inertia> drivers) {
        return Executors.newFixedThreadPool(drivers.size());
    }

    @Override
    public void shutDownExecutorService(ExecutorService executor) {
        try {
            executor.shutdown();
            executor.awaitTermination(60, TimeUnit.SECONDS);
        }
        catch (InterruptedException e) {
            System.err.println("termination interrupted");
        }
        finally {
            if (!executor.isTerminated()) {
                System.err.println("ending tasks");
            }
            executor.shutdownNow();
        }
        startRace = false;
    }

    @Override
    public boolean isStartRace() {
        return startRace;
    }
}
