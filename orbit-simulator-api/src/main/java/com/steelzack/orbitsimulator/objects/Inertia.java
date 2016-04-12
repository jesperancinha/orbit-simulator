package com.steelzack.orbitsimulator.objects;

/**
 * Created by joaofilipesabinoesperancinha on 09-04-16.
 */
public interface Inertia {
    void setKart(Planet planet);

    Planet getPlanet();

    String getName();
}
