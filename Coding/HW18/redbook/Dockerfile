# Use an image as base
FROM eclipse-temurin:17-jdk
LABEL authors="SC"

# Set the working directory
WORKDIR /app

# Copy the built JAR file into the container
COPY target/redbook-0.0.1-SNAPSHOT.jar app.jar

# Copy the Maven pom.xml file to the working directory
COPY ./pom.xml /app

# Expose the application port (modify if needed)
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]