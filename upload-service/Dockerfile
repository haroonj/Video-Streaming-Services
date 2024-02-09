FROM openjdk:17
EXPOSE 8080
ADD target/upload-service.jar upload-service.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","upload-service.jar"]