package com.steelzack.kartracelaps.manager;

import com.steelzack.kartracelaps.objects.Driver;

import java.util.Map;

/**
 * Created by joaofilipesabinoesperancinha on 09-04-16.
 */
public interface DriverManager {
    void addDriver(String name, Integer kartId);

    Map<Integer, Driver> getDriverList();

    Driver getDriverByKartId(Integer kartId);

    void restart();

    Integer getnLaps();
}
