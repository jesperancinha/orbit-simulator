package com.steelzack.orbitsimulator.manager;

import com.steelzack.orbitsimulator.exceptions.PlanetOutOfOrbitException;
import com.steelzack.orbitsimulator.objects.Inertia;
import com.steelzack.orbitsimulator.objects.Planet;
import com.steelzack.orbitsimulator.results.FastesPlanetOrbit;
import com.steelzack.orbitsimulator.results.Result;
import com.steelzack.orbitsimulator.results.Winner;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by joaofilipesabinoesperancinha on 09-04-16.
 */
public interface OrbitManager {
    void addDriver(String name, Integer kartId);

    void start() throws InterruptedException, ExecutionException, PlanetOutOfOrbitException;

    Collection<Inertia> getAllDrivers();

    List<Result> getResults();

    FastesPlanetOrbit getFastestLapFromResult(Planet winningKart, Result winningResult);

    Winner getWinnerFromResult(Planet winningKart);
}
