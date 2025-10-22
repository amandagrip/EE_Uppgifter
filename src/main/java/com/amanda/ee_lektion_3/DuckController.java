package com.amanda.ee_lektion_3;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class DuckController {

    private final DuckService duckService;


    public DuckController(@Qualifier("defaultDuckService") DuckService duckService) {
        this.duckService = duckService;
    }

    @GetMapping("/duck")
    public Mono<ResponseEntity<Duck>> getDuck(){
        return duckService.getDuck()
                .map(ResponseEntity::ok)
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @GetMapping("/duck/url")
    public Mono<ResponseEntity<String>> getDuckUrl(){
        return duckService.getDuck()
                .map(duck -> ResponseEntity.ok(duck.getUrl()))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));

    }
}
