FROM ubuntu:latest AS build
RUN apt-get update
RUN apt-get install openjdk-17-jdk -y
COPY . .
RUN ./gradle bootJar --no-daemon

FROM openjdk:17-jdk-slim
COPY --from=build /app/build/libs/spring-web-1.jar app.jar
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
