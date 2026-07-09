package org.jesperancinha.orbitsimulator.exception;

import java.text.MessageFormat;

/**
 * Created by joaofilipesabinoesperancinha on 09-04-16.
 */
public class NamePlanetMismatchException extends Exception {
    private final String names;
    private final String karIds;

    public NamePlanetMismatchException(String names, String karIds) {
        this.names = names;
        this.karIds = karIds;
    }

    @Override
    public String getMessage() {
        return MessageFormat.format("Missmatch between names: {0} and planetIds {1}", names, karIds);
    }
}
