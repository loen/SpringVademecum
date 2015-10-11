package com.andrzejpe.spring.prototype;

import org.springframework.stereotype.Component;

/**
 * Created by jedrek on 2015-10-11.
 */
@Component
public class Horse {

    private static int instanceNo = 0;

    public Horse() {
        instanceNo++;
    }

    public String horseNo() {
        return "it's horse " + instanceNo;
    }


}
