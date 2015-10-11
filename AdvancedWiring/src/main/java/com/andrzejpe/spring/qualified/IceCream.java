package com.andrzejpe.spring.qualified;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by jedrek on 2015-10-11.
 */
@Component
@Qualifier("cold")
public class IceCream implements Dessert {
    @Override

    public String getName() {
        return "ice cream";
    }
}
