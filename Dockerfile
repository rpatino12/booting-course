# Step 1: Use an official OpenJDK 21 base image
FROM openjdk:21-jdk-slim

# Step 2: Set the working directory inside the container
WORKDIR /app

# Step 3: Copy the Spring Boot JAR file into the container
# Replace 'your-app.jar' with the name of your Spring Boot JAR file
COPY target/booting-course-0.0.1-SNAPSHOT.jar app.jar

# Step 4: Define the command to run the application
CMD ["java", "-jar", "app.jar"]