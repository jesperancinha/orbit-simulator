package org.jesperancinha.orbitsimulator;

import org.jesperancinha.orbitsimulator.exceptions.PlanetOutOfOrbitException;
import org.jesperancinha.orbitsimulator.options.OrbitSimulatorOptions;
import picocli.CommandLine;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

/**
 *
 */
public class OrbitSimulatorMain {
    public static void main(String[] args) throws PlanetOutOfOrbitException, ExecutionException, InterruptedException, IOException {
        new CommandLine(new OrbitSimulatorOptions()).execute(args);
        final OrbitSimulatorOptions options = new OrbitSimulatorOptions();
        }
}
