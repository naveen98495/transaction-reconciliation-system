# Stage 1: Build the backend application
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests -f backend/pom.xml

# Stage 2: Run the application using a stable, available base image
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build /app/backend/target/reconciliation-system-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]