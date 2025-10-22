package com.amanda.ee_lektion_3;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class DuckWebClientConfig {

    @Bean
    public WebClient duckWebClientBuilder(WebClient.Builder builder){
        return builder
                .baseUrl("")
                .build();
    }
}
