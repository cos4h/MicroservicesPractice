package com.microservice.hotel.exception.handler;

import com.microservice.hotel.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleResourceNotFoundException(ResourceNotFoundException exception) {
      Map<String, Object> map = new HashMap<>();
      map.put("message", exception.getMessage());
      map.put("success", false);
      map.put("status", HttpStatus.NOT_FOUND);
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
    }

}