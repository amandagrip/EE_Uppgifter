package com.amanda.ee_lektion_3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class DefaultDuckService implements DuckService {

    private final WebClient webClient;

    @Autowired
    public DefaultDuckService(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public Mono<Duck> getDuck() {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/random")
                        .build()
                )
                .retrieve()
                .onStatus(
                        httpStatusCode -> httpStatusCode.is4xxClientError(),
                        clientResponse -> Mono.error(new RuntimeException("Client Error"))
                )
                .onStatus(
                        httpStatusCode -> httpStatusCode.is5xxServerError(),
                        clientResponse -> Mono.error(new RuntimeException("Server Error"))
                )
                .bodyToMono(Duck.class);
    }
}
