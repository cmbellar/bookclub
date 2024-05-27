# Build Stage
FROM maven:3.9.6-eclipse-temurin-17-alpine AS build

COPY . .
RUN mvn clean package -DskipTests

# Run Stage
FROM openjdk:17
COPY --from=build /target/*.jar bookclub.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","bookclub.jar"]
