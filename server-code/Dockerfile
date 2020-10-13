ARG JAVA_VERSION=8-slim
FROM openjdk:${JAVA_VERSION}

WORKDIR /app
COPY server-code/ .
COPY interface-code/ .
RUN chmod +x entrypoint.sh

RUN javac *.java

ENTRYPOINT [ "sh", "entrypoint.sh" ]
