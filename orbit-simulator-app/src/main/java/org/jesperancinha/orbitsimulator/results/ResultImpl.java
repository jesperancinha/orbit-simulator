package org.jesperancinha.orbitsimulator.results;


import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by joaofilipesabinoesperancinha on 09-04-16.
 */
public class ResultImpl implements Result {
    private static final DateTimeFormatter DATE_FORMATTER =
            DateTimeFormatter.ofPattern("HH:mm:ss");
    private final String inertiaName;
    private final Integer planetNumber;
    private final LocalTime timeStampForOrbit;
    private final Integer orbitDuration;
    private final Integer orbitNumber;

    public ResultImpl( //
                       String inertiaName, //
                       Integer planetNumber, //
                       LocalTime timeStampForOrbit, //
                       Integer orbitDuration, //
                       Integer orbitNumber //
    ) {
        this.inertiaName = inertiaName;
        this.planetNumber = planetNumber;
        this.timeStampForOrbit = timeStampForOrbit;
        this.orbitDuration = orbitDuration;
        this.orbitNumber = orbitNumber;
    }

    public String getInertiaName() {
        return inertiaName;
    }

    public Integer getPlanetNumber() {
        return planetNumber;
    }

    public LocalTime getTimeStampForOrbit() {
        return timeStampForOrbit;
    }

    @Override
    public String getTimeStampString() {
        return DATE_FORMATTER.format(timeStampForOrbit);
    }

    public Integer getOrbitDuration() {
        return orbitDuration;
    }

    @Override
    public String toString() {
        return inertiaName.concat(",").concat(planetNumber.toString()).concat(",").concat(getTimeStampString());
    }

    public Integer getOrbitNumber() {
        return orbitNumber;
    }
}
