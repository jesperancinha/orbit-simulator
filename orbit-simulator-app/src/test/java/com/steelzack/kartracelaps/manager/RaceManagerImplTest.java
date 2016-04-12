package com.steelzack.kartracelaps.manager;

import com.steelzack.kartracelaps.objects.KartImpl;
import com.steelzack.kartracelaps.results.FastestLap;
import com.steelzack.kartracelaps.results.Result;
import com.steelzack.kartracelaps.results.ResultImpl;
import com.steelzack.kartracelaps.results.Winner;
import org.junit.Test;

import java.time.LocalTime;

import static org.junit.Assert.assertEquals;

/**
 * Created by joaofilipesabinoesperancinha on 09-04-16.
 */
public class RaceManagerImplTest {
    @Test
    public void getFastestLapFromResult() throws Exception {
        final RaceManager raceManager = new RaceManagerImpl(100, 150, 10, 100);
        final KartImpl testWinninKart = new KartImpl(0, 100, 150, 10);
        final ResultImpl testWinningResult = new ResultImpl("Test", 0, LocalTime.now(), 400, 3);

        final FastestLap fastestLap = raceManager.getFastestLapFromResult(testWinninKart, testWinningResult);

        assertEquals("Kart number 0 was the fasted with 400 ms on lap number 3", fastestLap.toString());
    }

    @Test
    public void getWinnerFromResult() throws Exception {
        final RaceManager raceManager = new RaceManagerImpl(100, 150, 10, 100);

        final Winner winner = raceManager.getWinnerFromResult(new KartImpl(1, 100, 150, 100));

        assertEquals("Kart 1 is the winner! It only took 0 ms! Congratulations!", winner.toString());
    }

    @Test
    public void start() throws Exception {
        final RaceManager raceManager = new RaceManagerImpl(100, 150, 10, 100);
        raceManager.addDriver("Racer 1", 1);
        raceManager.addDriver("Racer 2", 2);
        raceManager.addDriver("Racer 3", 3);
        raceManager.addDriver("Racer 4", 4);
        raceManager.addDriver("Racer 5", 5);

        raceManager.start();

        for (Result result : raceManager.getResults()) {
            System.out.println(result.toString());
        }

    }
}