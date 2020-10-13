ARG JAVA_VERSION=8-slim
FROM openjdk:${JAVA_VERSION}

WORKDIR /app
COPY client-code/ .
COPY interface-code/ .

RUN javac *.java

# change me to [ "java", "<file name with main in it (without .java)>" ]
ENTRYPOINT [ "java", "calculatorclient" ]
