package com.jfse.kartracelaps.manager;

import org.junit.Test;

/**
 * Created by joaofilipesabinoesperancinha on 09-04-16.
 */
public class RaceManagerImplTest {
    @Test
    public void start() throws Exception {
        final RaceManagerImpl raceManager = new RaceManagerImpl(1000,1500, 10, 100);
        raceManager.addDriver("Racer 1",1);
        raceManager.addDriver("Racer 2",2);
        raceManager.addDriver("Racer 3",3);
        raceManager.addDriver("Racer 4",4);
        raceManager.addDriver("Racer 5",5);

        raceManager.start();

        raceManager.getAllDrivers();
    }
}