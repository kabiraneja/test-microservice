# Use a base image with Java 11 (OpenJDK 11) as the runtime environment
FROM openjdk:17-jdk

# Set the working directory inside the container
WORKDIR /

# Copy the Spring Boot application JAR from the target directory of the Maven build into the container
COPY target/demo_2-0.0.1-SNAPSHOT.jar /app.jar

# Expose the port that your Spring Boot application is listening on (adjust the port number if needed)
EXPOSE 9091

# Define the command to run the Spring Boot application when the container starts
CMD ["java", "-jar", "app.jar"]
