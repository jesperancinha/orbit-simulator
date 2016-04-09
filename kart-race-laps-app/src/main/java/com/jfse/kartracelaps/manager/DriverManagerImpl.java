package com.jfse.kartracelaps.manager;

import com.jfse.kartracelaps.objects.Driver;
import com.jfse.kartracelaps.objects.DriverImpl;
import com.jfse.kartracelaps.objects.Kart;
import com.jfse.kartracelaps.objects.KartImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joaofilipesabinoesperancinha on 09-04-16.
 */
public class DriverManagerImpl implements DriverManager {
    final List<String> driverList;
    private Integer minTimeForLap;
    private Integer maxTimeForLap;
    private Integer nLaps;

    public DriverManagerImpl(Integer minTimeForLap, Integer maxTimeForLap, Integer nLaps)
    {
        this.minTimeForLap = minTimeForLap;
        this.maxTimeForLap = maxTimeForLap;
        this.nLaps = nLaps;
        driverList = new ArrayList<>();
    }

    @Override
    public void addDriver(String name, Integer kartId) {
        final Kart kart = new KartImpl(kartId, minTimeForLap, maxTimeForLap, nLaps);
        final Driver driver = new DriverImpl(kart, name);
    }

    @Override
    public List<String> getDriverList() {
        return driverList;
    }
}
