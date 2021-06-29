FROM openjdk:8-jdk-alpine
COPY target/*.jar EmployeeProxy-1.0-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/EmployeeProxy-1.0-SNAPSHOT.jar"]
