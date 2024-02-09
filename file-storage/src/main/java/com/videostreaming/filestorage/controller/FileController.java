package com.videostreaming.filestorage.controller;


import com.videostreaming.filestorage.util.S3Util;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileController {

    private final S3Util s3Util;

    public FileController(S3Util s3Util) {
        this.s3Util = s3Util;
    }

    @PostMapping("/")
    public String uploadToS3(@RequestBody MultipartFile file, @RequestParam("name") String name) {
        try {
            s3Util.uploadFile(name, file.getInputStream());
            return "success";
        } catch (Exception e) {
            return "failed";
        }
    }
}
