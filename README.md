# Voting System I2

Voting System

[![Build Status](https://travis-ci.org/Arquisoft/Voting_I2.svg?branch=master)](https://travis-ci.org/Arquisoft/Voting_I2)
[![Codacy Badge](https://api.codacy.com/project/badge/grade/56f2751d907b403bb19bac6b318f7364)](https://www.codacy.com/app/jelabra/Voting_I2)
[![codecov.io](https://codecov.io/github/Arquisoft/Voting_I2/coverage.svg?branch=master)](https://codecov.io/github/Arquisoft/Voting_I2?branch=master)

#Docs Proyect
[Link here](https://unioviedo-my.sharepoint.com/personal/uo231396_uniovi_es/_layouts/15/guestaccess.aspx?docid=0cbb55636e76041c5923feeb764b4866a&authkey=Ac9jPgZM3_I4d0AU7eQwztM)

#Description of the project
https://arquisoft.github.io/Voting_I2/

# Build

In order to ease the build and run phase docker compose is used, you just need to run:
```
$ docker-compose up
```
* The Voters REST API will be started at port `8443`
* The Voters web view will be started at port `8888`
* The Results web view will be started at port `8080`
* The VotingSystem web view will be started at port `8200`

The first time you start the system you need to run this script:
```
$ ./startup
```

If you want to add new people to the census you should run the `add_censuses` script with the proper file:
```
$ ./add_censuses /path/to/file.csv
``` 

Once a poll is finished, to run the counting:
```
$ ./start_counting
```

# Authors

* Jose Labra
* Fabio Martinez Gonzalez
* Andrea Vega Campos
* Pablo Mendendez Barrientos
* Roberto Fernandez Diaz
* Luis Emilio Velasco Sanchez
* Santiago Casero Laredo
