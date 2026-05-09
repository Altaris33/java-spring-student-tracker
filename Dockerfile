# Use a lightweight Java runtime
FROM eclipse-temurin:25

# Set working directory
WORKDIR /app

# Copy JAR into container
COPY target/student_tracker-0.0.1-SNAPSHOT.jar app.jar

# Expose port
EXPOSE 7070

# Run application
ENTRYPOINT ["java", "-jar", "app.jar"]