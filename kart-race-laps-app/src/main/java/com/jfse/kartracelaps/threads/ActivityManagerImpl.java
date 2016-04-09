package com.jfse.kartracelaps.threads;

import com.jfse.kartracelaps.exceptions.DriverAccidentException;
import com.jfse.kartracelaps.manager.DriverManager;
import com.jfse.kartracelaps.objects.Driver;
import com.jfse.kartracelaps.objects.Kart;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by joaofilipesabinoesperancinha on 09-04-16.
 */
public class ActivityManagerImpl implements ActivityManager {
    private final DriverManager driverManager;
    private boolean startRace = false;

    public ActivityManagerImpl(DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    @Override
    public void startRace() throws ExecutionException, InterruptedException, DriverAccidentException {
        startRace = true;
        final List<Driver> drivers = driverManager.getDriverList();
        List<Future<Kart>> allDriverWaiter = new ArrayList<>();
        ExecutorService executor = Executors.newFixedThreadPool(drivers.size());

        for (Driver driver : drivers) {
            Future<Kart> future = executor.submit(driver.getKart().startRacing());
            allDriverWaiter.add(future);
        }

        for (Future<Kart> future : allDriverWaiter) {
            Kart kart = future.get();
            if (!kart.isSuccess()) {
                throw new DriverAccidentException(kart.getKartId());
            }
        }
        startRace = false;
    }

    public boolean isStartRace() {
        return startRace;
    }
}
