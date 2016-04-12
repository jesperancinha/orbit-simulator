package com.steelzack.orbitsimulator.objects;

import org.junit.Test;

import java.time.LocalTime;

import static org.junit.Assert.assertEquals;

/**
 * Created by joaofilipesabinoesperancinha on 09-04-16.
 */
public class KartImplTest {

    @Test
    public void addTimeStamp() throws Exception {
        final Integer kartId = 0;
        final Integer minTimeForLap = 1000;
        final Integer maxTimeForLap = 1000;
        final Integer nLaps = 10;
        final Kart kart = new PlanetImpl(kartId, minTimeForLap, maxTimeForLap, nLaps);
        final Integer lap = 0;
        final LocalTime time = LocalTime.now();

        kart.addSnapshot(0, new FreezeMomentImpl(time, 0));

        assertEquals(time, kart.getSnapshotByLap(lap).getTimeStamp());
    }
}