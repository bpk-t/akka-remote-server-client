FROM java:openjdk-8-alpine
ADD target/scala-2.12/server.jar /work/
WORKDIR /work

CMD ["java", "-jar", "server.jar"]