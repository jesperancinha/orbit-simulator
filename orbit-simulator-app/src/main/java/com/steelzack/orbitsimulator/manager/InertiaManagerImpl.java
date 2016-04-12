package com.steelzack.orbitsimulator.manager;

import com.steelzack.orbitsimulator.objects.Inertia;
import com.steelzack.orbitsimulator.objects.InertiaImpl;
import com.steelzack.orbitsimulator.objects.Planet;
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
    private Integer orbitNumber;

    public InertiaManagerImpl(Integer minTimeForLap, Integer maxTimeForLap, Integer nLaps) {
        this.minTimeForLap = minTimeForLap;
        this.maxTimeForLap = maxTimeForLap;
        this.orbitNumber = nLaps;
        driverList = new HashMap<>();
    }

    @Override
    public void addDriver(String name, Integer planetId) {
        final Planet planet = new PlanetImpl(planetId, minTimeForLap, maxTimeForLap, orbitNumber);
        final Inertia driver = new InertiaImpl(planet, name);
        driverList.put(planetId, driver);
    }

    @Override
    public Map<Integer, Inertia> getDriverList() {
        return driverList;
    }

    @Override
    public Inertia getDriverByKartId(Integer planetId) {
        return driverList.get(planetId);
    }

    @Override
    public void restart() {
        driverList.clear();
    }

    public Integer getOrbitNumber() {
        return orbitNumber;
    }
}
