package com.example.ee_lektion_5;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("messages")
public record Message(
        @Id Long id,
        String message,
        LocalDateTime createdAt,
        boolean pinned
) {}
