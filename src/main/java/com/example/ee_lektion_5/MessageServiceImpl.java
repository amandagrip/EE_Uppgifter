package com.example.ee_lektion_5;

import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.time.LocalDateTime;
import org.slf4j.Logger;

@Service
@Primary
public class MessageServiceImpl implements MessageService {

    private static final Logger log = LoggerFactory.getLogger(MessageServiceImpl.class);
    private final MessageRepository messageRepository;

    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public Flux<Message> getAllMessages() {
        log.info("Hämtar alla meddelanden...");
        return messageRepository.findAll();
    }

    @Override
    public Mono<Message> getMessageById(Long id) {
        log.info("Hämtar meddelande med ID: {}", id);
        return messageRepository.findById(id);
    }

    @Override
    public Mono<Message> createMessage(Message message) {
        log.info("Skapar nytt meddelande: {}", message.message());

        Message newMessage = new Message(
                null,
                message.message(),
                LocalDateTime.now(),
                true);

        return messageRepository.save(newMessage)
                .doOnSuccess(saved -> log.info("Meddelande sparat med ID: {}", saved.id()))
                .doOnError(error -> log.error("Fel vid sparande av meddelande", error));
    }
}
// Uppgift 5,5 = Ej bra att skriva datumet på det sättet då det kan bli fel format samt att den inte anpassas för olika tidszoner.
// Istället kan man sätta datumet automatiskt med LocalDateTime.now()
