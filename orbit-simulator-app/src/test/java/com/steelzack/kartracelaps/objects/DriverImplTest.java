package com.steelzack.kartracelaps.objects;

import org.junit.Test;

import static org.junit.Assert.assertSame;

/**
 * Created by joaofilipesabinoesperancinha on 09-04-16.
 */
public class DriverImplTest {
    @Test
    public void getKart() throws Exception {
        final Integer kartId = 0;
        final Integer minTimeForLap = 1000;
        final Integer maxTimeForLap = 1000;
        final Integer nLaps = 10;
        final Kart kart = new KartImpl(kartId,  minTimeForLap, maxTimeForLap, nLaps);
        final String name = "Player 1";
        final Driver driver = new DriverImpl(kart, name);


        assertSame(kart, driver.getKart());
        assertSame(kartId, driver.getKart().getKartId());
        assertSame("Player 1", driver.getName());
    }
}