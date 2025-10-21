# ------------ Build Stage ------------
FROM maven:3.9.5-eclipse-temurin-17 AS build
WORKDIR /app
COPY src .
RUN mvn clean package -DskipTests

# ------------ Runtime Stage ------------
FROM eclipse-temurin:17-jre
WORKDIR /app

# Copy only the JAR (adjust the name if needed)
COPY --from=build /app/target/Bank-0.0.1-SNAPSHOT.jar app.jar

# Expose the port (Render uses PORT env)
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
