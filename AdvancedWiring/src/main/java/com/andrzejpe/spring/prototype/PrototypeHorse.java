package com.andrzejpe.spring.prototype;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by jedrek on 2015-10-11.
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PrototypeHorse {
    private static int instanceNo = 0;
    private int horseNo;

    public PrototypeHorse() {
        instanceNo++;
        horseNo = instanceNo;
    }

    public String horseNo() {
        return "it's horse " + horseNo;
    }
}
