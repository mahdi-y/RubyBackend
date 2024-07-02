# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the executable JAR file to the working directory
COPY target/EurekaServer-0.0.1-SNAPSHOT.jar eureka-server.jar

# Expose the port the app runs on
EXPOSE 8761

# Run the jar file
ENTRYPOINT ["java", "-jar", "eureka-server.jar"]