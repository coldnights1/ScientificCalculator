# Use an official Maven image as a builder
FROM maven:3.8.3-openjdk-17 AS build

# Set the working directory to /usr/src/app
WORKDIR /app

# Copy the local project to the container
COPY pom.xml .
COPY src ./src

# Build the project with Maven
RUN mvn clean package

# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-alpine

# Set the working directory to /usr/app
WORKDIR /app

# Copy the built JAR file from the Maven image
COPY --from=build /app/target/*.jar ./app.jar

EXPOSE 8080
# Specify the command to run your application
CMD ["java", "-jar", "app.jar"]
