package com.jfse.kartracelaps.manager;

import com.jfse.kartracelaps.objects.Driver;

import java.util.List;

/**
 * Created by joaofilipesabinoesperancinha on 09-04-16.
 */
public interface DriverManager {
    void addDriver(String name, Integer kartId);

    List<Driver> getDriverList();

    void restart();
}
