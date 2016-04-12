package com.steelzack.kartracelaps.manager;

import com.steelzack.kartracelaps.exceptions.DriverAccidentException;
import com.steelzack.kartracelaps.objects.Driver;
import com.steelzack.kartracelaps.objects.Kart;
import com.steelzack.kartracelaps.results.FastestLap;
import com.steelzack.kartracelaps.results.Result;
import com.steelzack.kartracelaps.results.Winner;

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
