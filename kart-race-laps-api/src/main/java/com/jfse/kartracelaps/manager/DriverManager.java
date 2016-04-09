package com.jfse.kartracelaps.manager;

import java.util.List;

/**
 * Created by joaofilipesabinoesperancinha on 09-04-16.
 */
public interface DriverManager {
    void addDriver(String name, Integer kartId);

    List<String> getDriverList();
}
