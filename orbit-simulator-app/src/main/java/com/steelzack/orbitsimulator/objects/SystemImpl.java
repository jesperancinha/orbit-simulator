package com.steelzack.orbitsimulator.objects;

/**
 * Created by joaofilipesabinoesperancinha on 09-04-16.
 */
public class SystemImpl implements System {

    /**
     * Represents the number of laps
     */
    private Integer nLaps;


    public Integer getnLaps() {
        return nLaps;
    }

    public void setnLaps(Integer nLaps) {
        this.nLaps = nLaps;
    }
}
