package com.andrzejpe.spring.exceptions;

/**
 * Created by jedrek on 2015-10-31.
 */
public class NotKnownException extends RuntimeException {

    public NotKnownException(String message) {
        super(message);
    }
}
