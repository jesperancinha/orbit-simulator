package com.steelzack.orbitsimulator.objects;

/**
 * Created by joaofilipesabinoesperancinha on 09-04-16.
 */
public class InertiaImpl implements Inertia {
    private Planet planet;

    private String name;

    public InertiaImpl(Planet planet, String name)
    {
        this.planet = planet;
        this.planet.setDriver(this);
        this.name = name;
    }

    /**
     * Inertia may need to change planet
     * @param planet Kart
     */
    @Override
    public void setKart(Planet planet) {
        this.planet = planet;
    }

    /**
     * Gets the Planet assigned to the driver
     * @return
     */
    @Override
    public Planet getPlanet() {
        return planet;
    }

    /**
     * This is the drivers name. It should not be modified
     * @return
     */
    @Override
    public String getName() {
        return name;
    }
}
