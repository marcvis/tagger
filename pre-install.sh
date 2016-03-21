#!/usr/bin/env bash
 mvn install:install-file \
-Dfile=src/main/resources/library/stanford-postagger-3.6.0.jar \
-DgroupId=stanford \
-DartifactId=postagger \
-Dversion=3.6.0 \
-Dpackaging=jar \
-DgeneratePom=true