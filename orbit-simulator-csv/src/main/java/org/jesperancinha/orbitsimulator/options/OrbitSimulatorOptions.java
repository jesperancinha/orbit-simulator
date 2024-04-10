package org.jesperancinha.orbitsimulator.options;

import com.opencsv.CSVWriter;
import org.jesperancinha.orbitsimulator.manager.OrbitManager;
import org.jesperancinha.orbitsimulator.manager.OrbitManagerImpl;
import org.jesperancinha.orbitsimulator.results.Result;

import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.Callable;

import static picocli.CommandLine.Option;

/**
 * Created by joaofilipesabinoesperancinha on 09-04-16.
 */
public class OrbitSimulatorOptions implements Callable<Integer> {

    private static final String PASSINGTIME = "passingtime";
    private static final String KART = "planet";

    @Option(names = {"--names-comma-separated", "-n"}, required = true)
    private String names;

    @Option(names = {"--planet-ids-comma-separated", "-k"})
    private String planetIds = null;

    @Option(names = {"--min-simulation-time", "-min"}, required = true)
    private Integer minSimulationTime;

    @Option(names = {"--max-simulation-time", "-max"}, required = true)
    private Integer maxSimulationTime;

    @Option(names = {"--number-of-laps", "-laps"}, required = true)
    private Integer nLaps;

    @Option(names = {"--track-length", "-t"})
    private Integer trackLength;

    @Option(names = {"--output-file", "-of"}, required = true)
    private String outputFile;

    public String getKartIds() {
        return planetIds;
    }

    public String getNames() {
        return names;
    }

    public Integer getMinSimulationTime() {
        return minSimulationTime;
    }

    public Integer getMaxSimulationTime() {
        return maxSimulationTime;
    }

    public Integer getnLaps() {
        return nLaps;
    }

    public Integer getTrackLength() {
        return trackLength;
    }

    public String getOutputFile() {
        return outputFile;
    }

    @Override
    public Integer call() throws Exception {
        final String[] names = getNames().split(",");
        String[] planetIds = null;
        if (getKartIds() != null) {
            planetIds = getKartIds().split(",");
        }

        final OrbitManager raceManager = new OrbitManagerImpl(
                getMinSimulationTime(), //
                getMaxSimulationTime(), //
                getnLaps(), //
                getTrackLength() //
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

        final String outputFile = getOutputFile();
        writeResultsToCsvFile(raceManager, outputFile);
        return 0;
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

