FROM gradle:8.0.2-jdk21 AS build

WORKDIR /app

COPY . /app

RUN chmod +x gradlew

RUN ./gradlew clean build -x test

FROM openjdk:21-jdk-slim

EXPOSE 8080

COPY --from=build /app/build/libs/spring-web-0.0.1-SNAPSHOT.jar /app/spring-web-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "/app/spring-web-0.0.1-SNAPSHOT.jar"]
