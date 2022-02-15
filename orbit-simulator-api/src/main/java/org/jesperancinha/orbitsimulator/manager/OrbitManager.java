package org.jesperancinha.orbitsimulator.manager;

import org.jesperancinha.orbitsimulator.exceptions.PlanetOutOfOrbitException;
import org.jesperancinha.orbitsimulator.objects.Inertia;
import org.jesperancinha.orbitsimulator.objects.Planet;
import org.jesperancinha.orbitsimulator.results.FastesPlanetOrbit;
import org.jesperancinha.orbitsimulator.results.Result;
import org.jesperancinha.orbitsimulator.results.Winner;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by joaofilipesabinoesperancinha on 09-04-16.
 */
public interface OrbitManager {
    void addDriver(String name, Integer planetId);

    void start() throws InterruptedException, ExecutionException, PlanetOutOfOrbitException;

    Collection<Inertia> getAllDrivers();

    List<Result> getResults();

    FastesPlanetOrbit getFastestLapFromResult(Planet winningKart, Result winningResult);

    Winner getWinnerFromResult(Planet winningKart);
}
