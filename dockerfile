# Stage 1: Build the application
# Using the official Gradle image with JDK 17
FROM gradle:8.8-jdk17 AS build
WORKDIR /app

# Copy only the configuration files first to cache dependencies
COPY build.gradle settings.gradle ./
# Copy the source code
COPY src ./src

# Build the Spring Boot executable JAR (skipping tests for speed)
RUN gradle bootJar --no-daemon -x test

# Stage 2: Final lightweight runtime image
FROM eclipse-temurin:21-jdk-jammy
WORKDIR /app

# Copy the built JAR from the first stage
# Gradle places the JAR in build/libs/ instead of Maven's target/
COPY --from=build /app/build/libs/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
