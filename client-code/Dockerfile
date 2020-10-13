ARG JAVA_VERSION=8-slim
FROM openjdk:${JAVA_VERSION}

WORKDIR /app
COPY client-code/ .
COPY interface-code/ .
RUN chmod +x entrypoint.sh

RUN javac *.java

ENTRYPOINT [ "sh", "entrypoint.sh" ]
