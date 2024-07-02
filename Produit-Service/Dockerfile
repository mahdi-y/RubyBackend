# Example Dockerfile
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the application JAR file into the container
COPY target/produit-service.jar /app/produit-service.jar

# Copy the application.properties file into the container
COPY src/main/resources/application.properties /app/application.properties

# Expose the port your application runs on
EXPOSE 8083

# Specify the command to run your application
CMD ["java", "-jar", "produit-service.jar"]
