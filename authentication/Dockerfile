FROM openjdk:17
EXPOSE 8060
ADD target/authentication.jar authentication.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","authentication.jar"]