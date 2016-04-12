package com.steelzack.orbitsimulator.objects;

import java.text.MessageFormat;
import java.time.LocalTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by joaofilipesabinoesperancinha on 09-04-16.
 */
public class PlanetImpl implements Planet {
    private static final Logger LOGGER = Logger.getLogger(PlanetImpl.class.getName());
    private static Random RANDOM = new Random();

    private Map<Integer, FreezeMoment> lapTimes;
    private Integer kartId;

    private final Integer minTimeForLap;
    private final Integer maxTimeForLap;

    private final Integer nLaps;
    private boolean success;
    private Inertia driver;


    public PlanetImpl(Integer kartId, Integer minTimeForLap, Integer maxTimeForLap, Integer nLaps) {
        this.kartId = kartId;
        this.minTimeForLap = minTimeForLap;
        this.maxTimeForLap = maxTimeForLap;
        this.nLaps = nLaps;
        lapTimes = new HashMap<>();
    }

    @Override
    public void setDriver(Inertia driver) {
        this.driver = driver;
    }

    /**
     * Adds a timestamp to a car for a lap.
     *
     * @param lap
     * @param snapshot
     */
    @Override
    public void addSnapshot(Integer lap, FreezeMoment snapshot) {
        lapTimes.put(lap, snapshot);
    }

    /**
     * Get the timestamp for a lap.
     *
     * @param lap
     * @return
     */
    @Override
    public FreezeMoment getSnapshotByLap(Integer lap) {
        return lapTimes.get(lap);
    }

    /**
     * Gets the kart assigned Id
     *
     * @return
     */
    @Override
    public Integer getPlanetId() {
        return kartId;
    }

    /**
     * Creates the run task for the kart to run
     *
     * @return The callable function so that can wait for all the karts to finish line.
     */
    @Override
    public Callable<Planet> startRacing() {
        Callable<Planet> task = () -> {
            try {
                for (int i = 1; i <= nLaps; i++) {
                    final Integer simulatedTimeToWait = getSimulatedTimeToWait();
                    LOGGER.log(Level.INFO, //
                            MessageFormat.format("{0} begins lap {1} at {2}", //
                                    this.driver.getName(), //
                                    i, //
                                    LocalTime.now()) //
                    );
                    TimeUnit.MILLISECONDS.sleep(simulatedTimeToWait);
                    final LocalTime registeringTime = LocalTime.now();
                    lapTimes.put(i, new FreezeMomentImpl(registeringTime, simulatedTimeToWait));
                    LOGGER.log(Level.INFO, //
                            MessageFormat.format("{0} had finished lap {1} at {2}", //
                                    this.driver.getName(), //
                                    i, //
                                    registeringTime) //
                    );
                }
                this.success = true;
                return this;
            } catch (InterruptedException e) {
                LOGGER.log(Level.SEVERE, "A kart is out of track!", e);
                this.success = false;
                return this;
            }
        };
        return task;
    }

    @Override
    public Integer getSimulatedTimeToWait() throws InterruptedException {
        return RANDOM.nextInt(maxTimeForLap - minTimeForLap) + minTimeForLap;
    }

    @Override
    public boolean isSuccess() {
        return success;
    }

    @Override
    public Integer getCompleteDuration() {
        final Collection<FreezeMoment> snapshots = lapTimes.values();
        Integer duration = 0;
        for (FreezeMoment snapshot : snapshots) {
            duration += snapshot.getDuration();
        }
        return duration;
    }
}
