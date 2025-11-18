package com.example.ee_lektion_5;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MessageService {
    Flux<Message> getAllMessages();
    Mono<Message> getMessageById(Long id);
    Mono<Message> createMessage(Message message);
}
