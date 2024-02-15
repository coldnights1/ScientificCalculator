# Use an official Maven image as a builder
FROM maven:3.8.3-openjdk-17 AS build

# Set the working directory to /usr/src/app
WORKDIR /usr/src/app

# Copy the local project to the container
COPY . .

# Build the project with Maven
RUN mvn clean install

# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-alpine

# Set the working directory to /usr/app
WORKDIR /usr/app

# Copy the built JAR file from the Maven image
COPY --from=build /usr/src/app/target/your-artifact-id-version.jar .

# Specify the command to run your application
CMD ["java", "-jar", "your-artifact-id-version.jar"]
