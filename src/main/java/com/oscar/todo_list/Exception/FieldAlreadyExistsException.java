package com.oscar.todo_list.Exception;

public class FieldAlreadyExistsException extends RuntimeException {
    public FieldAlreadyExistsException(String fieldName, String message) {
        super(String.format("Field %s already exists: %s", fieldName, message));
    }
}
