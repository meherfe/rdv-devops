# Stage 1: Build the application
FROM maven:3.8.4-openjdk-17 AS builder

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven project files
COPY . .

# Build the application and skip tests
RUN mvn clean package -Dmaven.test.skip=true

# Stage 2: Run the application
FROM openjdk:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the builder stage
COPY --from=builder /app/target/examen-RDV-1.0.jar /app/examen-RDV-1.0.jar

EXPOSE 8080

CMD ["java", "-jar", "examen-RDV-1.0.jar"]
