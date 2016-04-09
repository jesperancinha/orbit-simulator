package com.jfse.kartracelaps.options;

import org.kohsuke.args4j.Option;

/**
 * Created by joaofilipesabinoesperancinha on 09-04-16.
 */
public class KartOptions {

    @Option(name = "--names-comma-separated", aliases = "-n", required = true)
    private String names;

    @Option(name = "--kart-ids-comma-separated", aliases = "-k", required = false)
    private String kartIds;

    public String getKartIds() {
        return kartIds;
    }

    public String getNames() {
        return names;
    }
}

