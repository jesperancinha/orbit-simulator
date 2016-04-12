package com.steelzack.orbitsimulator.manager;

import com.steelzack.orbitsimulator.exceptions.PlanetOutOfOrbitException;
import com.steelzack.orbitsimulator.objects.Inertia;
import com.steelzack.orbitsimulator.objects.Orbit;
import com.steelzack.orbitsimulator.objects.OrbitImpl;
import com.steelzack.orbitsimulator.objects.Planet;
import com.steelzack.orbitsimulator.results.*;
import com.steelzack.orbitsimulator.threads.ActivityManager;
import com.steelzack.orbitsimulator.threads.ActivityManagerImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;

/**
 * Created by joaofilipesabinoesperancinha on 09-04-16.
 */
public class OrbitManagerImpl implements OrbitManager {
    private static final Logger LOGGER = Logger.getLogger(OrbitManagerImpl.class.getName());

    private final InertiaManager driverManager;
    private final Orbit track;
    private FastesPlanetOrbit fastestLap;
    private Winner winner;

    /**
     * @param minTimeForLap In miliseconds
     * @param maxTimeForLap In miliseconds
     * @param nLaps         Unit number of laps
     * @param trackLength   Length in km
     */
    public OrbitManagerImpl(Integer minTimeForLap, Integer maxTimeForLap, Integer nLaps, Integer trackLength) {
        driverManager = new InertiaManagerImpl(minTimeForLap, maxTimeForLap, nLaps);
        track = new OrbitImpl(trackLength);
    }

    @Override
    public void addDriver(String name, Integer planetId) {
        driverManager.addDriver(name, planetId);
    }

    @Override
    public void start() throws InterruptedException, ExecutionException, PlanetOutOfOrbitException {
        final ActivityManager activityManager = new ActivityManagerImpl(driverManager);
        activityManager.startRace();
    }

    @Override
    public Collection<Inertia> getAllDrivers() {
        return driverManager.getDriverList().values();
    }

    @Override
    public List<Result> getResults() {
        final List<Result> results = new ArrayList<>();
        for (final Inertia driver : getAllDrivers()) {
            for (int i = 1; i <= driverManager.getOrbitNumber(); i++) {
                final Result result = new ResultImpl(
                        driver.getName(), //
                        driver.getPlanet().getPlanetId(), //
                        driver.getPlanet().getSnapshotByLap(i).getTimeStamp(), //
                        driver.getPlanet().getSnapshotByLap(i).getDuration(),
                        i);
                results.add(result);
            }
        }

        orderResultsByDuration(results);
        final Result winningResult = results.get(0);
        final Inertia driverWinner = driverManager.getDriverByKartId(winningResult.getPlanetNumber());
        final Planet winningPlanet = driverWinner.getPlanet();

        this.winner = getWinnerFromResult(winningPlanet);
        this.fastestLap = getFastestLapFromResult(winningPlanet, winningResult);

        orderResultListByTimeStamp(results);

        return results;
    }

    @Override
    public FastesPlanetOrbit getFastestLapFromResult(Planet winningKart, Result winningResult) {
        final FastesPlanetOrbit fastestLap = new FastestPlanetOrbitImpl( //
                winningKart.getPlanetId(), //
                winningResult.getOrbitDuration(), //
                winningResult.getOrbitNumber() //
        );
        LOGGER.info(fastestLap.toString());
        return  fastestLap;
    }

    @Override
    public Winner getWinnerFromResult(Planet winningKart) {
        final Winner winner = new WinnerImpl( //
                winningKart.getPlanetId(), //
                winningKart.getCompleteDuration() //
        );
        LOGGER.info(winner.toString());
       return winner;
    }

    private void orderResultsByDuration(List<Result> results) {
        Collections.sort(results, //
                (Result result1, Result result2) //
                        -> result1.getOrbitDuration().compareTo(result2.getOrbitDuration()));
    }

    private void orderResultListByTimeStamp(List<Result> results) {
        Collections.sort(results, //
                (Result result1, Result result2) //
                        -> result1.getTimeStampForOrbit().compareTo(result2.getTimeStampForOrbit()));
    }

}
