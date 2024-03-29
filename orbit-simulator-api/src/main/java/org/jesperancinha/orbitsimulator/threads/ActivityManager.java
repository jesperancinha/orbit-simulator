package org.jesperancinha.orbitsimulator.threads;

import org.jesperancinha.orbitsimulator.exceptions.PlanetOutOfOrbitException;
import org.jesperancinha.orbitsimulator.objects.Inertia;

import java.util.Collection;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;

/**
 * Created by joaofilipesabinoesperancinha on 09-04-16.
 */
public interface ActivityManager {
    void startRace() throws ExecutionException, //
            InterruptedException, //
            PlanetOutOfOrbitException; //

    ExecutorService getExecutorService(Collection<Inertia> drivers);

    void shutDownExecutorService(ExecutorService executor);

    boolean isStartRace();
}
