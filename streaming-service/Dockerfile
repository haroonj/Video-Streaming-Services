FROM openjdk:17
EXPOSE 8080
ADD target/streaming-service.jar streaming-service.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","streaming-service.jar"]