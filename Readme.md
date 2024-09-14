# Orbit simulator

---


[![Generic badge](https://img.shields.io/static/v1.svg?label=GitHub&message=orbit-simulator%20🪐&color=informational)](https://github.com/jesperancinha/orbit-simulator)

[![GitHub License](https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg?style=flat)](https://www.apache.org/licenses/LICENSE-2.0)

[![orbit-simulator](https://github.com/jesperancinha/orbit-simulator/actions/workflows/orbit-simulator.yml/badge.svg)](https://github.com/jesperancinha/orbit-simulator/actions/workflows/orbit-simulator.yml)

[![Codacy Badge](https://app.codacy.com/project/badge/Grade/88b8779c26da429ca7e9c7ebabef8679)](https://www.codacy.com/gh/jesperancinha/orbit-simulator/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=jesperancinha/orbit-simulator&amp;utm_campaign=Badge_Grade)

[![Codacy Badge](https://app.codacy.com/project/badge/Coverage/88b8779c26da429ca7e9c7ebabef8679)](https://www.codacy.com/gh/jesperancinha/orbit-simulator/dashboard?utm_source=github.com&utm_medium=referral&utm_content=jesperancinha/orbit-simulator&utm_campaign=Badge_Coverage)
[![Coverage Status](https://coveralls.io/repos/github/jesperancinha/orbit-simulator/badge.svg?branch=master)](https://coveralls.io/github/jesperancinha/orbit-simulator?branch=master)
[![codecov](https://codecov.io/gh/jesperancinha/orbit-simulator/branch/master/graph/badge.svg?token=Hf6KTdVR9e)](https://codecov.io/gh/jesperancinha/orbit-simulator)

[![GitHub language count](https://img.shields.io/github/languages/count/jesperancinha/orbit-simulator.svg)](#)
[![GitHub top language](https://img.shields.io/github/languages/top/jesperancinha/orbit-simulator.svg)](#)
[![GitHub top language](https://img.shields.io/github/languages/code-size/jesperancinha/orbit-simulator.svg)](#)

---

## Description

This project is intended to be a realtime orbiting planets simulation.

This is just a codebase that intends to explore the multithreading world.

More updates coming soon...

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

## About me

[![GitHub followers](https://img.shields.io/github/followers/jesperancinha.svg?label=Jesperancinha&style=for-the-badge&logo=github&color=grey "GitHub")](https://github.com/jesperancinha)
