package com.inventory.exception;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends RuntimeException {

    private HttpStatus statusCode = HttpStatus.NOT_FOUND;

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public ResourceNotFoundException(String resourceId) {

        super(String.format("Resource id not found: %s", resourceId));

    }
}
