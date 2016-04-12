package com.steelzack.orbitsimulator.results;

import java.time.LocalTime;

/**
 * Created by joaofilipesabinoesperancinha on 09-04-16.
 */
public interface Result {
    String getDriverName();

    Integer getKartNumber();

    LocalTime getTimeStamp();

    String getTimeStampString();

    Integer getDuration();

    Integer getLapNumber();
}
