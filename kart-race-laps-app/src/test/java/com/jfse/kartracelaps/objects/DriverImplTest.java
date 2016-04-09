package com.jfse.kartracelaps.objects;

import org.junit.Test;

import static org.junit.Assert.assertSame;

/**
 * Created by joaofilipesabinoesperancinha on 09-04-16.
 */
public class DriverImplTest {
    @Test
    public void getKart() throws Exception {
        final Integer kartId = 0;
        final Kart kart = new KartImpl(kartId, minTimeForLap, maxTimeForLap, nLaps);
        final Driver driver = new DriverImpl(kart, name);


        assertSame(kart, driver.getKart());
        assertSame(kartId, driver.getKart().getKartId());
    }
}