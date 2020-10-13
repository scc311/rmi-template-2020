#! /bin/bash

echo "Running JAVA RMI Registry..."
rmiregistry &

echo "Running Your Server..."
java calculatorserver
