#! /bin/bash

echo "Running JAVA RMI Registry..."
rmiregistry &

echo "Running Your Server..."

# change me to java <file name with main in it (without .java)>
java calculatorserver
