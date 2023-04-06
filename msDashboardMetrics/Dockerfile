FROM adoptopenjdk/openjdk11:alpine
#FROM openjdk11-jdk
MAINTAINER krupakar
#RUN apt update ; apt install telnet -y
WORKDIR /app
ADD target/msDashboardMetrics-0.1.jar /app/msDashBoardMetrics.jar
CMD ["java","-jar","./msDashBoardMetrics.jar"]
