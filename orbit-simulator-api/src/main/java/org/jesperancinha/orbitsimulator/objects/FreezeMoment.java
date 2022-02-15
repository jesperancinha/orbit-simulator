package org.jesperancinha.orbitsimulator.objects;

import java.time.LocalTime;

/**
 * Created by joaofilipesabinoesperancinha on 09-04-16.
 */
public interface FreezeMoment {
    Integer getDuration();

    LocalTime getTimeStamp();
}
