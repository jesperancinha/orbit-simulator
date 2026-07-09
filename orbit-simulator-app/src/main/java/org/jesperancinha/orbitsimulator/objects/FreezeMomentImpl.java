package org.jesperancinha.orbitsimulator.objects;

import java.time.LocalTime;

/**
 * Created by joaofilipesabinoesperancinha on 09-04-16.
 */
public class FreezeMomentImpl implements FreezeMoment {
    private final LocalTime timeStamp;

    private final Integer duration;

    public FreezeMomentImpl(LocalTime timeStamp, Integer duration) {
        this.timeStamp = timeStamp;
        this.duration = duration;
    }

    @Override
    public Integer getDuration() {
        return duration;
    }

    @Override
    public LocalTime getTimeStamp() {
        return timeStamp;
    }
}
