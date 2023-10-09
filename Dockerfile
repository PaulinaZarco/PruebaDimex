
FROM postgres:latest
ENV POSTGRES_USER Paulina
ENV POSTGRES_PASSWORD dimex
ENV POSTGRES_DB dimex
EXPOSE 5432


FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app
COPY target/examen-0.0.1-SNAPSHOT-exec.jar app.jar
EXPOSE 9090

ENTRYPOINT ["java", "-jar", "app.jar"]
