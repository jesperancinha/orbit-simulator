package com.steelzack.orbitsimulator.results;

import java.text.MessageFormat;

/**
 * Created by joaofilipesabinoesperancinha on 09-04-16.
 */
public class FastestPlanetOrbitImpl implements FastesPlanetOrbit {

    private Integer karNumber;

    private Integer duration;

    private Integer number;

        public FastestPlanetOrbitImpl(Integer karNumber, Integer duration, Integer number) {
        this.karNumber = karNumber;
        this.duration = duration;
        this.number = number;
    }

    @Override
    public String toString() {
        return MessageFormat.format( //
                "Planet number {0} was the fasted with {1} ms on lap number {2}", //
                karNumber, //
                duration, //
                number //
        );
    }
}
