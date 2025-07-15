FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY target/hotel-management-0.0.1-SNAPSHOT.war app.war
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "app.war"]
