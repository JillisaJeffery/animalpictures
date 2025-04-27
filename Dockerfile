# Use an official OpenJDK + Maven image as base
FROM maven:3.9.6-eclipse-temurin-17

# Set the working directory inside the container
WORKDIR /app

# Copy everything
COPY . .

# Build the app, skipping tests
RUN mvn clean package -DskipTests

# Run the app
CMD ["java", "-jar", "target/animalpictures-0.0.1-SNAPSHOT.jar"]

