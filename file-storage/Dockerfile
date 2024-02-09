FROM openjdk:17
EXPOSE 8060
ADD target/file-storage.jar file-storage.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","file-storage.jar"]