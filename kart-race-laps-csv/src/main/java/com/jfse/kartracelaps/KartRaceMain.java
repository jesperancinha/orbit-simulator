package com.jfse.kartracelaps;

import com.jfse.kartracelaps.options.KartOptions;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;

/**
 * Hello world!
 *
 */
public class KartRaceMain
{
    public static void main( String[] args ) throws CmdLineException {
        final KartOptions options = new KartOptions();
        final CmdLineParser parser = new CmdLineParser(options);
        parser.parseArgument(args);

        if(options.getKartIds() != null)
        {

        }
    }
}
