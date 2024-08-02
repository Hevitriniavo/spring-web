FROM gradle:8.0.2-jdk17 AS build
COPY . .

RUN ./gradlew build --no-daemon -x test

FROM openjdk:17-jdk-slim

COPY --from=build /app/build/libs/spring-web-1.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
