package com.jfse.kartracelaps.objects;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by joaofilipesabinoesperancinha on 09-04-16.
 */
public class KartImpl implements Kart {
    private Map<Integer, LocalTime> lapTimes;

    public KartImpl(){
        lapTimes = new HashMap<>();
    }

     /**
     * Adds a timestamp to a car for a lap.
     * @param lap
     * @param timeStamp
     */
     @Override
     public void  addTimeStamp(Integer lap, LocalTime timeStamp) {
        lapTimes.put(lap, timeStamp);
    }

    /**
     * Get the timestamp for a lap.
     * @param lap
     * @return
     */
    @Override
    public LocalTime getTimeStampByLap(Integer lap) {
        return lapTimes.get(lap);
    }
}
