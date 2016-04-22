#!/usr/bin/env bash
sh reset.sh
mvn clean
mvn install -DskipTests
mvn test
cd tests
mvn test -Dintegrate=true
