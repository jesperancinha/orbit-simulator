package com.steelzack.orbitsimulator.results;

import java.text.MessageFormat;

/**
 * Created by joaofilipesabinoesperancinha on 09-04-16.
 */
public class WinnerImpl implements Winner {

    private Integer planetNumber;

    private Integer totalRaceTime;

    public WinnerImpl(Integer kartNumber, Integer totalRaceTime) {
        this.planetNumber = kartNumber;
        this.totalRaceTime = totalRaceTime;
    }

    @Override
    public String toString(){
        return MessageFormat.format("Planet {0} is the winner! It only took {1} ms! Congratulations!", planetNumber,totalRaceTime);
    }
}
