# Use a pre-bundled Maven + Java environment directly
FROM maven:3.8.5-openjdk-17

# Set the working space inside the container
WORKDIR /app

# Copy your backend source code 
COPY . .

# Package the application
RUN mvn clean package -DskipTests

# Expose your port and run the jar directly from the target folder
EXPOSE 8080
CMD ["java", "-jar", "target/reconciliation-system-0.0.1-SNAPSHOT.jar"]