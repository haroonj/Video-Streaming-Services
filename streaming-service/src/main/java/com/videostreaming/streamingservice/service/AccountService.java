package com.videostreaming.streamingservice.service;

import com.videostreaming.streamingservice.auth.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class AccountService {
    private final WebClient webClient;

    @Autowired
    public AccountService(WebClient.Builder webClient) {
        this.webClient = webClient.baseUrl("http://authentication:8070").build();
    }

    public boolean auth(Account account) {
        Boolean response = webClient.post()
                .uri("/")
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(account), Account.class)
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();
        return Boolean.TRUE.equals(response);
    }

}
