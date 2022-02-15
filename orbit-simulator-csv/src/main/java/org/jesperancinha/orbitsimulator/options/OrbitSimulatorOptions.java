package org.jesperancinha.orbitsimulator.options;

import org.kohsuke.args4j.Option;

/**
 * Created by joaofilipesabinoesperancinha on 09-04-16.
 */
public class OrbitSimulatorOptions {

    @Option(name = "--names-comma-separated", aliases = "-n", required = true)
    private String names;

    @Option(name = "--planet-ids-comma-separated", aliases = "-k", required = false)
    private String planetIds = null;

    @Option(name = "--min-simulation-time", aliases = "-min", required = true)
    private Integer minSimulationTime;

    @Option(name = "--max-simulation-time", aliases = "-max", required = true)
    private Integer maxSimulationTime;

    @Option(name = "--number-of-laps", aliases = "-laps", required = true)
    private Integer nLaps;

    @Option(name = "--track-length", aliases =  "-t", required = false)
    private Integer trackLength;

    @Option(name = "--output-file", aliases = "-of", required = true)
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
}

