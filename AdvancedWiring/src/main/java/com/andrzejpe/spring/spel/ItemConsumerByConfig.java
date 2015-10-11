package com.andrzejpe.spring.spel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by jedrek on 2015-10-11.
 */

@Component
public class ItemConsumerByConfig {

    @Value("#{item.name}")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
