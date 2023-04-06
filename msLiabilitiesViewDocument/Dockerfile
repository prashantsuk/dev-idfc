FROM adoptopenjdk/openjdk11:alpine
#FROM openjdk11-jdk
MAINTAINER krupakar
#RUN apt update ; apt install telnet -y
WORKDIR /app
ADD target/msLiabilitiesViewDocument-0.1.jar /app/msLiabilitiesViewDocument.jar
CMD ["java","-jar","./msLiabilitiesViewDocument.jar"]
