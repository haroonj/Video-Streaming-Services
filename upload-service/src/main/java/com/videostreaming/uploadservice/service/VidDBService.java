package com.videostreaming.uploadservice.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class VidDBService {
    private final WebClient webClient;

    @Autowired
    public VidDBService(WebClient.Builder webClient) {
        this.webClient = webClient.baseUrl("http://database:8090").build();
    }

    public boolean putVidToDB(VidMetaData data) {
        Boolean response = webClient.post()
                .uri("/")
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(data), VidMetaData.class)
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();
        System.out.println(response);
        return Boolean.TRUE.equals(response);
    }
}
