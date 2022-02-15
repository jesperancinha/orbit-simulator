package org.jesperancinha.orbitsimulator.objects;

import org.junit.Test;

import static org.junit.Assert.assertSame;

/**
 * Created by joaofilipesabinoesperancinha on 09-04-16.
 */
public class DriverImplTest {
    @Test
    public void getKart() throws Exception {
        final Integer planetId = 0;
        final Integer minTimeForLap = 1000;
        final Integer maxTimeForLap = 1000;
        final Integer nLaps = 10;
        final Planet planet = new PlanetImpl(planetId,  minTimeForLap, maxTimeForLap, nLaps);
        final String name = "Player 1";
        final Inertia driver = new InertiaImpl(planet, name);


        assertSame(planet, driver.getPlanet());
        assertSame(planetId, driver.getPlanet().getPlanetId());
        assertSame("Player 1", driver.getName());
    }
}
