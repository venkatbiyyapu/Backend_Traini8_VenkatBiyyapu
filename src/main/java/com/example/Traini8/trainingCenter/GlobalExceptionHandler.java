package com.example.Traini8.trainingCenter;

import org.springframework.http.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles MethodArgumentNotValidException which occurs during validation of
     * request body data when it doesn't match the expected format or constraints.
     *
     * @param ex the exception object containing validation error details.
     * @return a ResponseEntity containing a map of field error messages and HTTP status code 400 (BAD REQUEST).
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        // Iterate over the field errors from the exception and populate the errors map
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });
        // Return a response entity with the errors map and a BAD REQUEST status
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);

    }
}
