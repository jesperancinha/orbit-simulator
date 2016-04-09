package com.jfse.kartracelaps.manager;

import com.jfse.kartracelaps.objects.Result;
import org.junit.Test;

/**
 * Created by joaofilipesabinoesperancinha on 09-04-16.
 */
public class RaceManagerImplTest {
    @Test
    public void start() throws Exception {
        final RaceManager raceManager = new RaceManagerImpl(1000,1500, 10, 100);
        raceManager.addDriver("Racer 1",1);
        raceManager.addDriver("Racer 2",2);
        raceManager.addDriver("Racer 3",3);
        raceManager.addDriver("Racer 4",4);
        raceManager.addDriver("Racer 5",5);

        raceManager.start();

        for(Result result : raceManager.getResults())
        {
            System.out.println(result.toString());
        }

    }
}