package com.andrzejpe.spring.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by jedrek on 2015-10-11.
 */
@Component
public class Rower {

    @Value("${rower.name}")
    private String name;

    public String getName() {
        return name;
    }

}
