FROM gradle:7.3.0-jdk11 AS build

WORKDIR /app

COPY . /app

RUN gradle clean build

FROM openjdk:11-jre-slim-buster

EXPOSE 8080

COPY --from=build /app/build/libs/spring-web-0.0.1-SNAPSHOT.jar /app/spring-web-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "/app/demo-0.0.1-SNAPSHOT.jar"]