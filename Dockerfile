FROM java:openjdk-8
VOLUME /tmp
EXPOSE 8080

RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app

COPY build.gradle /usr/src/app
ADD build/libs/pracslip-0.0.1-SNAPSHOT.jar /usr/src/app/app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/usr/src/app/app.jar"]