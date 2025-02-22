# Use a slim base image for running the application
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the pre-built JAR file from the local machine to the container's working directory
COPY target/redbook.jar redbook.jar

# Expose the port the application will run on
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "redbook.jar"]
