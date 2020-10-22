ARG JAVA_VERSION=8-slim
FROM openjdk:${JAVA_VERSION}

WORKDIR /app
COPY server-code/ .
COPY interface-code/ .
RUN chmod +x entrypoint.sh

RUN mkdir target/
RUN find . -name "*.java" > sources.txt
RUN javac -d target/ @sources.txt
RUN rm sources.txt

ENTRYPOINT [ "sh", "entrypoint.sh" ]
