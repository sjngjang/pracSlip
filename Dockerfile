FROM java:openjdk-8
VOLUME /tmp
EXPOSE 8080
COPY build/libs/pracslip-0.0.1-SNAPSHOT.jar pracslip.jar
ENV JAVA_OPTS=""
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev././urandom -Dspring.profiles.active=container -jar /pracslip.jar"]