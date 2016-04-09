package com.jfse.kartracelaps.threads;

import com.jfse.kartracelaps.exceptions.DriverAccidentException;

import java.util.concurrent.ExecutionException;

/**
 * Created by joaofilipesabinoesperancinha on 09-04-16.
 */
public interface ActivityManager {
    void startRace() throws ExecutionException, //
            InterruptedException, //
            DriverAccidentException; //

    boolean isStartRace();
}
