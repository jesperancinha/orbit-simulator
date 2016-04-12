package com.steelzack.orbitsimulator.results;

import java.time.LocalTime;

/**
 * Created by joaofilipesabinoesperancinha on 09-04-16.
 */
public interface Result {
    String getInertiaName();

    Integer getPlanetNumber();

    LocalTime getTimeStampForOrbit();

    String getTimeStampString();

    Integer getOrbitDuration();

    Integer getOrbitNumber();
}
