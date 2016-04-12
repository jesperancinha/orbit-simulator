package com.steelzack.orbitsimulator.objects;

import java.util.concurrent.Callable;

/**
 * Created by joaofilipesabinoesperancinha on 09-04-16.
 */
public interface Kart {
    void setDriver(Inertia driver);

    void addSnapshot(Integer lap, FreezeMoment snapshot);

    FreezeMoment getSnapshotByLap(Integer lap);

    Integer getKartId();

    Callable<Kart> startRacing();

    Integer getSimulatedTimeToWait() throws InterruptedException;

    boolean isSuccess();

    Integer getCompleteDuration();
}