package com.andrzejpe.spring.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by jedrek on 2015-10-31.
 */
@ResponseStatus(value= HttpStatus.BAD_GATEWAY, reason = "just like that!")
public class SomeException extends RuntimeException {
}
