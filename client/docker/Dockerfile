FROM java:openjdk-8-alpine
ADD target/scala-2.12/client.jar /work/
WORKDIR /work

CMD ["java", "-jar", "client.jar"]