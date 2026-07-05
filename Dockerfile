## Build Maven and load dependencies
FROM maven:latest AS build
WORKDIR /build
COPY pom.xml .
## install and loads maven tools
RUN mvn -B dependency:go-offline
COPY . .
RUN mvn package

## Load openJDK & runtimes
FROM eclipse-temurin:21-jre
WORKDIR /app

## Copy jar for app runtime
COPY --from=build /build/target/todo_list-0.0.1-SNAPSHOT.jar .

## PORT define
EXPOSE 3000

## Jar run app
ENTRYPOINT ["java", "-jar", "./todo_list-0.0.1-SNAPSHOT.jar"]