FROM java:openjdk-8
VOLUME /tmp
EXPOSE 8080
ADD target/pracslip-0.0.1-SNAPSHOT.jar pracslip.jar
ENV JAVA_OPTS=""
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /pracslip.jar"]