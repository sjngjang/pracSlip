FROM java:openjdk-8
EXPOSE 8080
RUN mkdir -p /app/
ADD build/libs/pracslip-0.0.1-SNAPSHOT.jar /app/pracslip.jar
ENTRYPOINT ["java", "-jar", "/app/pracslip.jar"]