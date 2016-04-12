## Orbit simulator

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

*Note: The code presented was initially intended to be used for a kart game*