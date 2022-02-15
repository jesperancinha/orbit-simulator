package org.jesperancinha.orbitsimulator;

import org.junit.Ignore;

/**
 * Created by joaofilipesabinoesperancinha on 09-04-16.
 */
public class KartRaceMainTest {
    @org.junit.Test
    @Ignore
    public void main() throws Exception {
        OrbitSimulatorMain.main(new String[]{ //
                "--names-comma-separated", //
                "racer1,racer2,racer3,racer4,racer5",
                "--planet-ids-comma-separated", //
                "1,2,3,4,5",
                "--min-simulation-time", //
                "100",
                "--max-simulation-time", //
                "150",
                "--number-of-laps", //
                "10", //
                "--track-length", //
                "1000", //
                "--output-file", //
                "/tmp/results.csv"//
        });
    }

}
