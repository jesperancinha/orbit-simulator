# Orbit simulator

## Description

This project is intended to be a realtime orbiting planets simulation.

This is just a codebase that intends to explore the multithreading world.

More updates comming soon...

## Build

Here is a quick description on how to run this example:

To build it and make the executable jar:

```
$ mvn clean install
$ cd orbit-simulator-csv
$ mvn clean compile assembly:single
```

The following is an example on how to run from the command line:

```
java -jar target/orbit-simulator-csv-1.0.0-SNAPSHOT-jar-with-dependencies.jar -n planet1,planet2,planet3,planet4,planet5 -k 1,2,3,4,5 -min 1000 -max 1500 -laps 10 -t 1000 -of /tmp/results.csv
```

## References

* http://www.phy6.org/stargaze/Smotion.htm

* https://www.grc.nasa.gov/www/k-12/rocket/corbit.html



*Note: The code presented was initially intended to be used for a race game. That is not the case anymore, but the base code stays for record*
