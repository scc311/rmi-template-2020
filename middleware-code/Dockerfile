ARG JAVA_VERSION=8-slim
FROM openjdk:${JAVA_VERSION}

COPY libraries/ /libs/
RUN chmod 700 /libs/*

WORKDIR /app
COPY middleware-code/ .
COPY interface-code/ .
RUN chmod +x entrypoint.sh

RUN javac -classpath /app:/libs/* *.java

ENTRYPOINT [ "sh", "entrypoint.sh" ]
