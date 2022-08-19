FROM openjdk:8
VOLUME /tmp
ADD target/audit-checklist-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]