package com.andrzejpe.spring.exception;

public class UserNotAllowedException extends RuntimeException {

    private String name;

    public UserNotAllowedException(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
