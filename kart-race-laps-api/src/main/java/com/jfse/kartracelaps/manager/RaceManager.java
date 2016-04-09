package com.jfse.kartracelaps.manager;

import com.jfse.kartracelaps.exceptions.DriverAccidentException;
import com.jfse.kartracelaps.objects.Driver;
import com.jfse.kartracelaps.objects.Kart;
import com.jfse.kartracelaps.results.FastestLap;
import com.jfse.kartracelaps.results.Result;
import com.jfse.kartracelaps.results.Winner;

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

    FastestLap getFastestLapFromResult(Kart winningKart, Result winningResult);

    Winner getWinnerFromResult(Kart winningKart);
}
