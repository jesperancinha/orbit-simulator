package com.steelzack.orbitsimulator.objects;

/**
 * Created by joaofilipesabinoesperancinha on 09-04-16.
 */
public class InertiaImpl implements Inertia {
    private Planet kart;

    private String name;

    public InertiaImpl(Planet kart, String name)
    {
        this.kart = kart;
        this.kart.setDriver(this);
        this.name = name;
    }

    /**
     * Inertia may need to change kart
     * @param kart Kart
     */
    @Override
    public void setKart(Planet kart) {
        this.kart = kart;
    }

    /**
     * Gets the Planet assigned to the driver
     * @return
     */
    @Override
    public Planet getPlanet() {
        return kart;
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
