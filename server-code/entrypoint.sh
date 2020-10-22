#! /bin/bash

echo "Running JAVA RMI Registry..."
rmiregistry -J-Djava.class.path="target/" &
sleep 1

echo "Running Your Server..."

# change me to java <file name with main in it (without .java)>
java -cp target/ calculatorserver
