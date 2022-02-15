package org.jesperancinha.orbitsimulator.objects;

import org.junit.Test;

import java.time.LocalTime;

import static org.junit.Assert.assertEquals;

/**
 * Created by joaofilipesabinoesperancinha on 09-04-16.
 */
public class KartImplTest {

    @Test
    public void addTimeStamp() throws Exception {
        final Integer planetId = 0;
        final Integer minTimeForLap = 1000;
        final Integer maxTimeForLap = 1000;
        final Integer nOrbits = 10;
        final Planet planet = new PlanetImpl(planetId, minTimeForLap, maxTimeForLap, nOrbits);
        final Integer orbit = 0;
        final LocalTime time = LocalTime.now();

        planet.addSnapshot(0, new FreezeMomentImpl(time, 0));

        assertEquals(time, planet.getSnapshotByLap(orbit).getTimeStamp());
    }
}
