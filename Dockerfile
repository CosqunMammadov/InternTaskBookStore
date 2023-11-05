FROM openjdk:17-oracle
ARG JAR_FILE=/build/libs/InternTaskBookStore-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} application.jar
ENTRYPOINT ["java","-jar","/application.jar"]
