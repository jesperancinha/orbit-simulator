package com.jfse.kartracelaps.objects;

import java.text.MessageFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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
    private static DateTimeFormatter DATEFORMATTER =
            DateTimeFormatter.ofPattern("hh:mm:ss.SSS");

    private Map<Integer, LocalTime> lapTimes;
    private Integer kartId;

    private final Integer minTimeForLap;
    private final Integer maxTimeForLap;

    private final Integer nLaps;
    private boolean success;
    private Driver driver;


    public KartImpl(Integer kartId, Integer minTimeForLap, Integer maxTimeForLap, Integer nLaps) {
        this.kartId = kartId;
        this.minTimeForLap = minTimeForLap;
        this.maxTimeForLap = maxTimeForLap;
        this.nLaps = nLaps;
        lapTimes = new HashMap<>();
    }

    @Override
    public void setDriver(Driver driver) {
        this.driver = driver;
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
     *
     * @return The callable function so that can wait for all the karts to finish line.
     */
    @Override
    public Callable<Kart> startRacing() {
        Callable<Kart> task = () -> {
            try {
                for (int i = 0; i < nLaps; i++) {
                    final Integer simulatedTimeToWait = getSimulatedTimeToWait();
                    LOGGER.log(Level.INFO, //
                            MessageFormat.format("{0} begins lap {1} at {2}", //
                                    this.driver.getName(), //
                                    i, //
                                    DATEFORMATTER.format(LocalTime.now())) //
                    );
                    TimeUnit.MILLISECONDS.sleep(simulatedTimeToWait);
                    lapTimes.put(i, LocalTime.now());
                    LOGGER.log(Level.INFO, //
                            MessageFormat.format("{0} had finished lap {1} at {2}", //
                                    this.driver.getName(), //
                                    i, //
                                    DATEFORMATTER.format(LocalTime.now())) //
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
}
