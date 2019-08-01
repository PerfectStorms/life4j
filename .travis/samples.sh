#!/bin/sh

# package console sample application
cd ${TRAVIS_BUILD_DIR}/samples/console/
mvn package
