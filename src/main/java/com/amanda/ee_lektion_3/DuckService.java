package com.amanda.ee_lektion_3;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public interface DuckService {
    Mono<Duck> getDuck();
}
