#! /usr/bin/env bash

set -e

mkdir -p ./data
AUTORENT_DATA_DIR="./data/"
export AUTORENT_DATA_DIR

ORM=$(find "./src/main/java/orm/" -type f -name "*.java")
MODELS=$(find "./src/main/java/model/" -type f -name "*.java")
UTIL=$(find "./src/main/java/util/" -type f -name "*.java")

JSON_JAR="./lib/json-20250517.jar"
SQLITE_JAR="./lib/sqlite-jdbc-3.50.3.0.jar"

SRC="$MODELS $ORM $UTIL"
CLASSPATH="./bin:$JSON_JAR:$SQLITE_JAR"

javac -cp "$CLASSPATH" -d "./bin" $SRC
java -cp "$CLASSPATH" src/test/java/Main.java
