FROM openjdk:8-jre-alpine
ENV SPRING_OUTPUT_ANSI_ENABLED=ALWAYS \JAVA_OPTS=""
WORKDIR /app
ADD target/*.war Timesheet-spring-boot-core-data-jpa-mvc-REST-1.war
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/Timesheet-spring-boot-core-data-jpa-mvc-REST-1.war"]