package com.jfse.kartracelaps.objects;

import java.time.LocalTime;
import java.util.concurrent.Callable;

/**
 * Created by joaofilipesabinoesperancinha on 09-04-16.
 */
public interface Kart {
    void setDriver(Driver driver);

    void  addTimeStamp(Integer lap, LocalTime timeStamp);

    LocalTime getTimeStampByLap(Integer lap);

    Integer getKartId();

    Callable<Kart> startRacing();

    Integer getSimulatedTimeToWait() throws InterruptedException;

    boolean isSuccess();
}
