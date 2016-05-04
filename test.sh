#!/usr/bin/env bash
cd censusesI2
sh startup
mvn test
cd ../votersI2
mvn test -DDB_URL=$DB_URL -DDB_USER=$DB_USER -DDB_PASSWORD=$DB_PASSWORD
cd ../VoteCounting_i2
sh test.sh
