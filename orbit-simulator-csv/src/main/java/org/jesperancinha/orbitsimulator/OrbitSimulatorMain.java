package org.jesperancinha.orbitsimulator;

import org.jesperancinha.orbitsimulator.exceptions.PlanetOutOfOrbitException;
import org.jesperancinha.orbitsimulator.manager.OrbitManager;
import org.jesperancinha.orbitsimulator.manager.OrbitManagerImpl;
import org.jesperancinha.orbitsimulator.results.Result;
import org.jesperancinha.orbitsimulator.options.OrbitSimulatorOptions;
import com.opencsv.CSVWriter;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;

import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

/**
 *
 */
public class OrbitSimulatorMain {

    public static final String PASSINGTIME = "passingtime";
    public static final String KART = "planet";

    public static void main(String[] args) throws CmdLineException,
            InterruptedException, //
            ExecutionException, //
            PlanetOutOfOrbitException, IOException //
    {
        final OrbitSimulatorOptions options = new OrbitSimulatorOptions();
        final CmdLineParser parser = new CmdLineParser(options);
        parser.parseArgument(args);
        final String[] names = options.getNames().split(",");
        String[] planetIds = null;
        if (options.getKartIds() != null) {
            planetIds = options.getKartIds().split(",");
        }

        final OrbitManager raceManager = new OrbitManagerImpl(
                options.getMinSimulationTime(), //
                options.getMaxSimulationTime(), //
                options.getnLaps(), //
                options.getTrackLength() //
        );

        if (planetIds == null) {
            for (int i = 0; i < names.length; i++) {
                raceManager.addDriver(names[i], i);
            }
        } else {
            for (int i = 0; i < names.length; i++) {
                raceManager.addDriver(names[i], Integer.parseInt(planetIds[i]));
            }
        }
        raceManager.start();

        final String outputFile = options.getOutputFile();
        writeResultsToCsvFile(raceManager, outputFile);
    }

    private static void writeResultsToCsvFile(OrbitManager raceManager, String outputFile) throws IOException {
        final CSVWriter writer = new CSVWriter(new FileWriter(outputFile));
        writer.writeNext(new String[]{KART, PASSINGTIME});
        for (Result result : raceManager.getResults()) {
            writer.writeNext(new String[]{result.getPlanetNumber().toString(), result.getTimeStampString()});
        }
        writer.flush();
        writer.close();
    }
}
