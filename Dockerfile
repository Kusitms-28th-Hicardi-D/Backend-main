FROM openjdk:11-jdk
VOLUME /tmp
ARG JAR_FILE=build/libs/hicardi-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} main-service.jar

ENTRYPOINT ["java","-jar","/main-service.jar"]