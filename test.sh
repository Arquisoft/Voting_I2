#!/usr/bin/env bash
sh startup
cd censusesI2
mvn test
cd ../votersI2
mvn test -DDB_URL=$DB_URL -DDB_USER=$DB_USER -DDB_PASSWORD=$DB_PASSWORD
cd VoteCounting_i2
sh test.sh
