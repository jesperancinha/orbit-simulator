package com.steelzack.orbitsimulator.manager;

import com.steelzack.orbitsimulator.objects.Inertia;
import com.steelzack.orbitsimulator.objects.InertiaImpl;
import com.steelzack.orbitsimulator.objects.Kart;
import com.steelzack.orbitsimulator.objects.PlanetImpl;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by joaofilipesabinoesperancinha on 09-04-16.
 */
public class InertiaManagerImpl implements InertiaManager {
    final Map<Integer, Inertia> driverList;
    private Integer minTimeForLap;
    private Integer maxTimeForLap;
    private Integer nLaps;

    public InertiaManagerImpl(Integer minTimeForLap, Integer maxTimeForLap, Integer nLaps) {
        this.minTimeForLap = minTimeForLap;
        this.maxTimeForLap = maxTimeForLap;
        this.nLaps = nLaps;
        driverList = new HashMap<>();
    }

    @Override
    public void addDriver(String name, Integer kartId) {
        final Kart kart = new PlanetImpl(kartId, minTimeForLap, maxTimeForLap, nLaps);
        final Inertia driver = new InertiaImpl(kart, name);
        driverList.put(kartId, driver);
    }

    @Override
    public Map<Integer, Inertia> getDriverList() {
        return driverList;
    }

    @Override
    public Inertia getDriverByKartId(Integer kartId) {
        return driverList.get(kartId);
    }

    @Override
    public void restart() {
        driverList.clear();
    }

    @Override
    public Integer getnLaps() {
        return nLaps;
    }
}
