package com.steelzack.orbitsimulator.exceptions;

import java.text.MessageFormat;

/**
 * Created by joaofilipesabinoesperancinha on 09-04-16.
 */
public class PlanetOutOfOrbitException extends Exception{

    private Integer inertiaId;

    public PlanetOutOfOrbitException(Integer inertiaId){
        this.inertiaId = inertiaId;
    }

    @Override
    public String getMessage() {
        return MessageFormat.format("Inertia {0} made the planet run out of orbit!", inertiaId);
    }
}
