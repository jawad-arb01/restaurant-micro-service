FROM openjdk:17-jdk-slim
WORKDIR /app
COPY . /app
RUN ./mvnw package
CMD ["java", "-jar", "target/client-service-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080