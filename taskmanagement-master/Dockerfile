# Use the official OpenJDK image as the base image
FROM openjdk:17-jdk



# Copy the jar file from the target directory to the container
COPY target/taskapp.jar .

# Expose the port on which the application will run
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "taskapp.jar"]