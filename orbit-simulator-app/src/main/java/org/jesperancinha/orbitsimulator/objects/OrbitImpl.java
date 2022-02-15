package org.jesperancinha.orbitsimulator.objects;

/**
 * Created by joaofilipesabinoesperancinha on 09-04-16.
 */
public class OrbitImpl implements Orbit {
    Integer trackLength;

    public OrbitImpl(Integer trackLength) {
        this.trackLength = trackLength;
    }

    @Override
    public Integer getTrackLength() {
        return trackLength;
    }
}
