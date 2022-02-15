package org.jesperancinha.orbitsimulator.manager;

import org.jesperancinha.orbitsimulator.objects.PlanetImpl;
import org.jesperancinha.orbitsimulator.results.FastesPlanetOrbit;
import org.jesperancinha.orbitsimulator.results.Result;
import org.jesperancinha.orbitsimulator.results.ResultImpl;
import org.jesperancinha.orbitsimulator.results.Winner;
import org.junit.Test;

import java.time.LocalTime;

import static org.junit.Assert.assertEquals;

/**
 * Created by joaofilipesabinoesperancinha on 09-04-16.
 */
public class OrbitManagerImplTest {
    @Test
    public void getFastestLapFromResult() throws Exception {
        final OrbitManager raceManager = new OrbitManagerImpl(100, 150, 10, 100);
        final PlanetImpl testWinninPlanet = new PlanetImpl(0, 100, 150, 10);
        final ResultImpl testWinningResult = new ResultImpl("Test", 0, LocalTime.now(), 400, 3);

        final FastesPlanetOrbit fastestLap = raceManager.getFastestLapFromResult(testWinninPlanet, testWinningResult);

        assertEquals("Planet number 0 was the fasted with 400 ms on orbit number 3", fastestLap.toString());
    }

    @Test
    public void getWinnerFromResult() throws Exception {
        final OrbitManager raceManager = new OrbitManagerImpl(100, 150, 10, 100);

        final Winner winner = raceManager.getWinnerFromResult(new PlanetImpl(1, 100, 150, 100));

        assertEquals("Planet 1 is the winner! It only took 0 ms! Congratulations!", winner.toString());
    }

    @Test
    public void start() throws Exception {
        final OrbitManager raceManager = new OrbitManagerImpl(100, 150, 10, 100);
        raceManager.addDriver("Planet 1", 1);
        raceManager.addDriver("Planet 2", 2);
        raceManager.addDriver("Planet 3", 3);
        raceManager.addDriver("Planet 4", 4);
        raceManager.addDriver("Planet 5", 5);

        raceManager.start();

        for (Result result : raceManager.getResults()) {
            System.out.println(result.toString());
        }

    }
}
