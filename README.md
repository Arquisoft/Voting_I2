# Voting System I2

Voting System

[![Build Status](https://travis-ci.org/Arquisoft/Voting_I2.svg?branch=master)](https://travis-ci.org/Arquisoft/Voting_I2)
[![Codacy Badge](https://api.codacy.com/project/badge/grade/56f2751d907b403bb19bac6b318f7364)](https://www.codacy.com/app/jelabra/Voting_I2)
[![codecov.io](https://codecov.io/github/Arquisoft/Voting_I2/coverage.svg?branch=master)](https://codecov.io/github/Arquisoft/Voting_I2?branch=master)

# Build

In order to ease the build and run phase docker compose is used, you just need to run:
```
$ docker-compose up
```
* The Voters REST API will be started at port `8443`
* The Voters web view will be started at port `8888`
* The Results web view will be started at port `8080`

If you want to add new people to the census you should run the `add_censuses` script with the proper file:
```
$ ./add_censuses /path/to/file.csv
``` 
If it is the first time you also need to run:
```
$ ./startup
```

Once a poll is finished, to run the counting:
```
$ ./start_counting
```
Refresca cabron

# Authors

* Jose Labra
* Fabio Martinez Gonzalez
* Andrea Vega Campos
* Pablo Mendendez Barrientos
* Roberto Fernandez Diaz
* Luis Emilio Velasco Sanchez
* Santiago Casero Laredo
