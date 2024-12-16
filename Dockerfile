# Stage 1: Build the app
FROM eclipse-temurin:17-jdk AS builder

# Set the working directory
WORKDIR /app

# Copy the application code
COPY . .

# Build the app (requires Maven or Gradle)
RUN ./mvnw clean package -DskipTests

#Stage 2: Run the app
FROM eclipse-temurin:17-jre

# Set the working directory
WORKDIR /app

# Copy the JAR file from the builder stage
COPY --from=builder /app/target/*.jar app.jar

# Expode the port the app will run on
EXPOSE 8080

# Comand to run the app
ENTRYPOINT ["java", "-jar", "app.jar"]