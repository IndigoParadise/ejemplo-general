FROM openjdk:11-ea-11-jdk-slim
COPY ../target/*.jar ejemplo-general.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar","/ejemplo-general.jar"]