package com.jfse.kartracelaps;

/**
 * Created by joaofilipesabinoesperancinha on 09-04-16.
 */
public class KartRaceMainTest {
    @org.junit.Test
    public void main() throws Exception {
        KartRaceMain.main(new String[]{ //
                "--names-comma-separated", //
                "racer1,racer2,racer3,racer4,racer5",
                "--kart-ids-comma-separated", //
                "1,2,3,4,5",
                "--min-simulation-time", //
                "1000",
                "--max-simulation-time", //
                "1500",
                "--number-of-laps", //
                "10", //
                "--track-length", //
                "1000", //
                "--output-file", //
                "/tmp/results.csv"//
        });
    }

}