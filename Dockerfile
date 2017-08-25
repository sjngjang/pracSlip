FROM java:openjdk-8
WORKDIR /app
ADD ./build/libs/pracslip-0.0.1-SNAPSHOT.jar /app/pracslip.jar
CMD java -Xdebug -Xrunjwp:server=y,transport=dt_socket,suspend=n -jar pracslip.jar