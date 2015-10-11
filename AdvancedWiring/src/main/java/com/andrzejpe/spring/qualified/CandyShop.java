package com.andrzejpe.spring.qualified;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by jedrek on 2015-10-11.
 */
@Component
public class CandyShop {

    @Autowired
    @Qualifier("cold")
    private Dessert dessert;

    public String getDessertName() {
        return dessert.getName();
    }

}
