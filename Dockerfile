FROM postgres
ENV POSTGRES_PASSWORD docker
ENV POSTGRES_DB n11bootcamp

FROM openjdk:1.8
ARG JAR_FILE=target/bootcamp-graduation-project-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} application.jar
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "application.jar"]