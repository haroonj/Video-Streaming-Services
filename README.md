# Video-Streaming-Services

**Date**: May 2022

## Table of Contents
1. [Introduction](#introduction)
2. [Problem Statement](#problem-statement)
3. [My Approach](#my-approach)
4. [Authentication Service](#authentication-service)
5. [File System Service](#file-system-service)
6. [The Upload Service](#the-upload-service)
7. [The Streaming Service](#the-streaming-service)
8. [Docker-Compose](#docker-compose)
9. [Docker Compose Content](#docker-compose-content)
10. [Docker-Compose up](#docker-compose-up)
11. [Conclusion](#conclusion)

## Introduction

Docker is an open-source containerization platform. It enables developers to package applications into containers—standardized executable components combining application source code with the operating system (OS) libraries and dependencies required to run that code in any environment.

## Problem Statement

Build a containerized Video Streaming System, where the user can upload and watch videos as a stream while authenticated. We have to use Docker Compose after containerizing our services.

## My Approach

After searching, reading, and a lot of practice, I have gone with implementing my solution as following:

1. **Authentication Service**: where it's the service to handle the validation of the user's credentials.
2. **File System Service**: I have gone with using S3 in my project, where this service has the responsibility of uploading the videos to the S3 bucket after the user uploads it through the upload service.
3. **The Upload Service**: The user here, after being authenticated, can upload the video he wants.
4. **Streaming Service**: a simple service to get the video's data from the database and then stream it to the user from S3.

## Authentication Service

Every request of my application should be authenticated; a simple service where other services send user credentials to validate. For demonstration purposes, the username and password are “admin”.

## File System Service

As mentioned, I’m using S3 as my storage. This service Handling the upload process to the bucket where it receives a multipart file with a name of the video and uploads it using this utility.

## The Upload Service

A service with a simple UI giving the user the ability to log in to the system and uploading a video. First, the user has to be authenticated, after he got redirected to the upload page to upload a video with a name and description, the metadata {video name, video description, URL, and the username} will be saved into the database, and the video itself will be uploaded to the S3 through the File System Service.

## The Streaming Service

Let us say the user has uploaded some videos, this service giving him the ability to watch these videos straight from the S3 as a stream, after he has been authenticated he got a list of videos to watch, where the videos data came from the database and the video streamed from the S3 after it was uploaded from File System Service.

## Docker-Compose

Docker Compose is a tool that was developed to help define and share multi-container applications. So… After implementing our services and creating a docker file to create the images for each service, we are now ready to run our system and bring it to life using docker compose.

## Docker Compose Content

First, we need a network to share through our system, for that I have created a simple network “testnet”. And of course, a volume to store the database data, so it does not erase when the containers are gone. And I have configured our five Services Images as the following:

- **Database**: I’m using the standard MySQL image with the dedicated network and volume.
- **Authentication Service**: And here connecting and exposing the Authentication Service image with its dedicated port.
- **File System Service**: As the previous doing here in the File System Service image.
- **The Upload Service**: Exposing and connecting the image, also mentioning the depends on images.
- **The Streaming Service**: Exposing and connecting the image, also mentioning the depends on the authentication.

## Docker-Compose up

After creating the docker-compose yml file and having the images(“have pushed them to my docker hub account “haroun9” ”), Now we are ready to ship and run our project with Docker-Compose up… As we see, we have six containers running together like harmony, each container handling a single responsibility.

## Conclusion

This project successfully demonstrates the power of containerization with Docker in building a scalable, modular video streaming platform. Utilizing a microservices architecture, each service is meticulously designed to perform its function, from user authentication to video streaming, ensuring high availability and efficient resource utilization. The use of Docker Compose simplifies deployment and scalability challenges, showcasing an elegant solution for managing complex applications with multiple interdependent services. Through this implementation, the project highlights the effectiveness of modern DevOps practices in creating robust, deployable applications capable of handling real-world demands.