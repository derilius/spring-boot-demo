FROM openjdk:latest

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

CMD ["java", "-jar", "/app.jar", "&"]

EXPOSE 9090
