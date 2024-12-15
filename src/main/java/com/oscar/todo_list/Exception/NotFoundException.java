package com.oscar.todo_list.Exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String resourceName, Long resourceId) {
        super(String.format("%s not found with id: %s", resourceName, resourceId));
    }
}
