package com.steelzack.orbitsimulator;

import com.steelzack.orbitsimulator.exceptions.DriverAccidentException;
import com.steelzack.orbitsimulator.manager.OrbitManager;
import com.steelzack.orbitsimulator.manager.OrbitManagerImpl;
import com.steelzack.orbitsimulator.results.Result;
import com.steelzack.orbitsimulator.options.OrbitSimulatorOptions;
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
    public static final String KART = "kart";

    public static void main(String[] args) throws CmdLineException,
            InterruptedException, //
            ExecutionException, //
            DriverAccidentException, IOException //
    {
        final OrbitSimulatorOptions options = new OrbitSimulatorOptions();
        final CmdLineParser parser = new CmdLineParser(options);
        parser.parseArgument(args);
        final String[] names = options.getNames().split(",");
        String[] kartIds = null;
        if (options.getKartIds() != null) {
            kartIds = options.getKartIds().split(",");
        }

        final OrbitManager raceManager = new OrbitManagerImpl(
                options.getMinSimulationTime(), //
                options.getMaxSimulationTime(), //
                options.getnLaps(), //
                options.getTrackLength() //
        );

        if (kartIds == null) {
            for (int i = 0; i < names.length; i++) {
                raceManager.addDriver(names[i], i);
            }
        } else {
            for (int i = 0; i < names.length; i++) {
                raceManager.addDriver(names[i], Integer.parseInt(kartIds[i]));
            }
        }
        raceManager.start();

        final String outputFile = options.getOutputFile();
        writeResultsToCsvFile(raceManager, outputFile);
    }

    private static void writeResultsToCsvFile(OrbitManager raceManager, String outputFile) throws IOException {
        final CSVWriter writer = new CSVWriter(new FileWriter(outputFile), '\t');
        writer.writeNext(new String[]{KART, PASSINGTIME});
        for (Result result : raceManager.getResults()) {
            writer.writeNext(new String[]{result.getKartNumber().toString(), result.getTimeStampString()});
        }
        writer.flush();
        writer.close();
    }
}
