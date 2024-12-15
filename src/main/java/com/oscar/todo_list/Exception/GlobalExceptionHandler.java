package com.oscar.todo_list.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    public ResponseEntity<Map<String, String>> buildResponseEntity(String message, HttpStatus status) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("message", message);
        errorResponse.put("status", String.valueOf(status.value()));
        return new ResponseEntity<>(errorResponse, status);
    }

    @ExceptionHandler(FieldAlreadyExistsException.class)
    public ResponseEntity<Map<String, String>> handleFieldAlreadyExistsException(FieldAlreadyExistsException e) {
        return buildResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Map<String, String>> handleEntityNotFoundException(NotFoundException e) {
        return buildResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
