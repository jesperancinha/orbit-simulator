package com.steelzack.orbitsimulator.objects;

/**
 * Created by joaofilipesabinoesperancinha on 09-04-16.
 */
public interface Inertia {
    void setKart(Planet kart);

    Planet getPlanet();

    String getName();
}
