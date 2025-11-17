package com.example.ee_lektion_4.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.HashMap;

@RestControllerAdvice
public class ValidationAdvice {

    private static final Logger logger = LoggerFactory.getLogger(ValidationAdvice.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<HashMap<String, String>> handleValidationErrors(
            MethodArgumentNotValidException exception
    ) {
        HashMap<String, String> errors = new HashMap<>();

        exception.getBindingResult().getFieldErrors().forEach(fieldError -> {errors.put(fieldError.getField(), fieldError.getDefaultMessage());
            logger.warn("Validation failed on field '{}': {}", fieldError.getField(), fieldError.getDefaultMessage());
        });

        logger.info("Returning {} validation errors", errors.size());
        return ResponseEntity.badRequest().body(errors);
    }
}
