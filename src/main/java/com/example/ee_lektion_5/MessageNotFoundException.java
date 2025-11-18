package com.example.ee_lektion_5;

public class MessageNotFoundException extends RuntimeException {
    public MessageNotFoundException(Long id) {
        super("Message with ID " + id + " not found");
    }
}
