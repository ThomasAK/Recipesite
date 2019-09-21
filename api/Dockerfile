FROM openjdk:8-alpine
COPY src /opt/app/src
COPY pom.xml /opt/app/
ARG JAR_FILE
COPY ${JAR_FILE} /opt/app.jar

EXPOSE 8080
CMD ["java","-jar","/opt/app.jar"]