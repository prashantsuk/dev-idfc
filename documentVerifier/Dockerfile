FROM adoptopenjdk/openjdk11:alpine
#FROM openjdk11-jdk
MAINTAINER krupakar
#RUN apt update ; apt install telnet -y
WORKDIR /app
ADD target/documentVerifier-0.0.1-SNAPSHOT.jar /app/documentVerifier.jar
CMD ["java","-jar","./documentVerifier.jar"]
