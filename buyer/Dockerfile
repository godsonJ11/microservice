FROM openjdk:17
WORKDIR /app
COPY target/buyer-0.0.1-SNAPSHOT.war /app/buyer-0.0.1-SNAPSHOT.war
CMD ["java", "-jar", "buyer-0.0.1-SNAPSHOT.war"]
# Use an OpenJDK base image
#FROM openjdk:11

# Set the working directory in the container
#WORKDIR /app

# Copy the packaged JAR file into the container
#COPY target/your-spring-boot-app.jar /app/your-spring-boot-app.jar

# Specify the command to run your Spring Boot application
#CMD ["java", "-jar", "your-spring-boot-app.jar"]