package com.steelzack.orbitsimulator.manager;

import com.steelzack.orbitsimulator.objects.Inertia;

import java.util.Map;

/**
 * Created by joaofilipesabinoesperancinha on 09-04-16.
 */
public interface InertiaManager {
    void addDriver(String name, Integer planetId);

    Map<Integer, Inertia> getDriverList();

    Inertia getDriverByKartId(Integer planetId);

    void restart();

    Integer getOrbitNumber();
}
