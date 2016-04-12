package com.steelzack.orbitsimulator.manager;

import com.steelzack.orbitsimulator.objects.Inertia;

import java.util.Map;

/**
 * Created by joaofilipesabinoesperancinha on 09-04-16.
 */
public interface InertiaManager {
    void addDriver(String name, Integer kartId);

    Map<Integer, Inertia> getDriverList();

    Inertia getDriverByKartId(Integer kartId);

    void restart();

    Integer getOrbitNumber();
}
