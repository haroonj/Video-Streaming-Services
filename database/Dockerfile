FROM openjdk:17
EXPOSE 8090
ADD target/database.jar database.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","database.jar"]