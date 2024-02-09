package com.videostreaming.filestorage.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class S3Config {

    @Value("${aws.s3.bucket}")
    private String bucket;

    @Value("${aws.access.key}")
    private String accessKey;

    @Value("${aws.access.secret}")
    private String accessSecret;

    @Value("${aws.region}")
    private String region;

}
