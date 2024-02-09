package com.videostreaming.uploadservice.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class UploadService {
    private final WebClient webClient;

    @Autowired
    public UploadService(WebClient.Builder webClient) {
        this.webClient = webClient.baseUrl("http://filestorage:8060").build();
    }

    public boolean upload(String fileName, MultipartFile multipartFile) {
        MultipartBodyBuilder builder = new MultipartBodyBuilder();
        builder.part("file", multipartFile.getResource());

        String response = webClient.post()
                .uri(uriBuilder -> uriBuilder.path("/")
                        .queryParam("name", fileName)
                        .build())
                .accept(MediaType.MULTIPART_FORM_DATA)
                .body(BodyInserters.fromMultipartData(builder.build()))
                .retrieve()
                .bodyToMono(String.class)
                .block();

        assert response != null;
        return response.equals("success");
    }
}
