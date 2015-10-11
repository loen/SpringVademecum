package com.andrzejpe.spring.properties;

import org.springframework.beans.factory.annotation.Value;

/**
 * Created by jedrek on 2015-10-11.
 */
public class Motor {

    private String name;

    public Motor(@Value("${motor.name}")String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }
}
