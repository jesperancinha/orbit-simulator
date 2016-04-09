package com.jfse.kartracelaps.manager;

import com.jfse.kartracelaps.exceptions.DriverAccidentException;
import com.jfse.kartracelaps.objects.Driver;
import com.jfse.kartracelaps.results.Result;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by joaofilipesabinoesperancinha on 09-04-16.
 */
public interface RaceManager {
    void addDriver(String name, Integer kartId);

    void start() throws InterruptedException, ExecutionException, DriverAccidentException;

    Collection<Driver> getAllDrivers();

    List<Result> getResults();
}
