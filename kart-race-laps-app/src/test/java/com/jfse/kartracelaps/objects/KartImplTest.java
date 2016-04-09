package com.jfse.kartracelaps.objects;

import org.junit.Test;

import java.time.LocalTime;

import static org.junit.Assert.assertEquals;

/**
 * Created by joaofilipesabinoesperancinha on 09-04-16.
 */
public class KartImplTest {

    @Test
    public void addTimeStamp() throws Exception {
        final Kart kart = new KartImpl();
        final Integer lap = 0;
        final LocalTime time = LocalTime.now();

        kart.addTimeStamp(0, time);

        assertEquals(time, kart.getTimeStampByLap(lap));
    }
}