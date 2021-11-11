FROM openjdk:8-jre-alpine
ENV SPRING_OUTPUT_ANSI_ENABLED=ALWAYS \JAVA_OPTS=""
WORKDIR /app
ADD target/*.war Timesheetdev.war
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/Timesheetdev.war"]