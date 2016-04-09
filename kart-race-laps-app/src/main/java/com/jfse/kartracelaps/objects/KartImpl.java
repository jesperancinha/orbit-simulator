package com.jfse.kartracelaps.objects;

import java.time.LocalTime;
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
public class KartImpl implements Kart {
    private static final Logger LOGGER = Logger.getLogger(KartImpl.class.getName());
    private static Random RANDOM = new Random();

    private Map<Integer, LocalTime> lapTimes;
    private Integer kartId;

    private final Integer minTimeForLap;
    private final Integer maxTimeForLap;

    private final Integer nLaps;

    public KartImpl(Integer kartId, Integer minTimeForLap, Integer maxTimeForLap, Integer nLaps) {
        this.kartId = kartId;
        this.minTimeForLap = minTimeForLap;
        this.maxTimeForLap = maxTimeForLap;
        this.nLaps = nLaps;
        lapTimes = new HashMap<>();
    }

    /**
     * Adds a timestamp to a car for a lap.
     *
     * @param lap
     * @param timeStamp
     */
    @Override
    public void addTimeStamp(Integer lap, LocalTime timeStamp) {
        lapTimes.put(lap, timeStamp);
    }

    /**
     * Get the timestamp for a lap.
     *
     * @param lap
     * @return
     */
    @Override
    public LocalTime getTimeStampByLap(Integer lap) {
        return lapTimes.get(lap);
    }

    /**
     * Gets the kart assigned Id
     *
     * @return
     */
    @Override
    public Integer getKartId() {
        return kartId;
    }

    /**
     * Creates the run task for the kart to run
     * @return The callable function so that can wait for all the karts to finish line.
     */
    @Override
    public Callable<Boolean> startRacing() {
        Callable<Boolean> task = () -> {
            try {
                for (int i = 0; i < nLaps; i++) {
                    TimeUnit.SECONDS.sleep(getSimulatedTimeToWait());
                    lapTimes.put(i, LocalTime.now());
                }
                return true;
            } catch (InterruptedException e) {
                LOGGER.log(Level.SEVERE, "A kart is out of track!", e);
                return false;
            }
        };
        return task;
    }

    @Override
    public Integer getSimulatedTimeToWait() throws InterruptedException {
       return  RANDOM.nextInt(maxTimeForLap - minTimeForLap) + minTimeForLap;
    }
}
