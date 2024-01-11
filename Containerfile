FROM docker.io/openjdk:11.0-jre-slim

RUN apt update -y && apt upgrade -y libc6 libpcre3

WORKDIR /work/
RUN chown :root /work \
    && chmod "g+rwX" /work \
    && chown :root /work

COPY target/*-runner.jar /work/application.jar

EXPOSE 8080

CMD ["java","-Xmx512m","-Xms256m","-jar","application.jar","-Dquarkus.http.host=0.0.0.0"]
