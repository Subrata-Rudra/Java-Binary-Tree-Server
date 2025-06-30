# Stage 1: Build the application using maven
FROM maven:3.9.6-eclipse-temurin-21 as build
# Creating a separate folder for the built project
WORKDIR /app

# Stage 2: Copy all files
COPY . .

# Stage 3: Build
RUN mvn clean package -DskipTests

# Stage 4: Package
FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY --from=build /app/target/treeServer-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]