package com.jfse.kartracelaps.manager;

import com.jfse.kartracelaps.exceptions.DriverAccidentException;
import com.jfse.kartracelaps.objects.Driver;
import com.jfse.kartracelaps.objects.Track;
import com.jfse.kartracelaps.objects.TrackImpl;
import com.jfse.kartracelaps.threads.ActivityManager;
import com.jfse.kartracelaps.threads.ActivityManagerImpl;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by joaofilipesabinoesperancinha on 09-04-16.
 */
public class RaceManagerImpl implements RaceManager {
    private final DriverManager driverManager;
    private final Track track;

    /**
     * @param minTimeForLap In miliseconds
     * @param maxTimeForLap In miliseconds
     * @param nLaps         Unit number of laps
     * @param trackLength   Length in km
     */
    public RaceManagerImpl(Integer minTimeForLap, Integer maxTimeForLap, Integer nLaps, Integer trackLength) {
        driverManager = new DriverManagerImpl(minTimeForLap, maxTimeForLap, nLaps);
        track = new TrackImpl(trackLength);
    }

    @Override
    public void addDriver(String name, Integer kartId) {
        driverManager.addDriver(name, kartId);
    }

    @Override
    public void start() throws InterruptedException, ExecutionException, DriverAccidentException {
        final ActivityManager activityManager = new ActivityManagerImpl(driverManager);
        activityManager.startRace();
    }

    @Override
    public List<Driver> getAllDrivers() {
        return driverManager.getDriverList();
    }
}
