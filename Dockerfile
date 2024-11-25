FROM openjdk:23-jdk

# Set the working directory inside the container
WORKDIR /app

# Copy the built Spring Boot JAR file into the container
COPY build/libs/coderHack-0.0.1-SNAPSHOT.jar app.jar

#expose port
EXPOSE 8080

# Set the command to run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]