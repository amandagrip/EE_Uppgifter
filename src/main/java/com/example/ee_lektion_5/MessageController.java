package com.example.ee_lektion_5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/messages")
public class MessageController {

    private static final Logger log = LoggerFactory.getLogger(MessageController.class);
    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    public Flux<Message> getAllMessages() {
        log.info("Hämtar alla meddelanden via controller...");
        return messageService.getAllMessages();
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Message>> getMessageById(@PathVariable Long id) {
        return messageService.getMessageById(id)
                .map(message -> ResponseEntity.ok(message))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Mono<ResponseEntity<Message>> createMessage(@Valid @RequestBody Message message) {
        log.info("Mottagit nytt meddelande via controller: {}", message.message());
        return messageService.createMessage(message)
                .map(savedMessage -> ResponseEntity.status(201).body(savedMessage))
                .doOnError(error -> log.error("Fel vid skapande av meddelande", error));
    }
}
