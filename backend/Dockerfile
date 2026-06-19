# Stage 1: Build the backend application
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
# Copy everything (including the backend folder) into the container
COPY . .
# Run the maven build pointing directly to the backend's pom.xml
RUN mvn clean package -DskipTests -f backend/pom.xml

# Stage 2: Run the application
FROM openjdk:17-jdk-slim
WORKDIR /app
# Copy the built jar from the backend's target directory
COPY --from=build /app/backend/target/reconciliation-system-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]