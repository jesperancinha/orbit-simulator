package com.steelzack.orbitsimulator.objects;

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
        final Kart kart = new PlanetImpl(kartId,  minTimeForLap, maxTimeForLap, nLaps);
        final String name = "Player 1";
        final Inertia driver = new InertiaImpl(kart, name);


        assertSame(kart, driver.getKart());
        assertSame(kartId, driver.getKart().getKartId());
        assertSame("Player 1", driver.getName());
    }
}