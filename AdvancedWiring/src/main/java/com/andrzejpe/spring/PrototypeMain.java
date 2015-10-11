package com.andrzejpe.spring;

import com.andrzejpe.spring.config.PrototypeConfig;
import com.andrzejpe.spring.prototype.Horse;
import com.andrzejpe.spring.prototype.PrototypeHorse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by jedrek on 2015-10-11.
 */
public class PrototypeMain {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(PrototypeConfig.class);
        Horse horse1 = ctx.getBean(Horse.class);
        Horse horse2 = ctx.getBean(Horse.class);
        Horse horse3 = ctx.getBean(Horse.class);
        System.out.println(horse1.horseNo());
        System.out.println(horse2.horseNo());
        System.out.println(horse3.horseNo());
        System.out.println("---- prototype horses ----");
        PrototypeHorse PrototypeHorse1 = ctx.getBean(PrototypeHorse.class);
        PrototypeHorse PrototypeHorse2 = ctx.getBean(PrototypeHorse.class);
        PrototypeHorse PrototypeHorse3 = ctx.getBean(PrototypeHorse.class);
        System.out.println(PrototypeHorse1.horseNo());
        System.out.println(PrototypeHorse2.horseNo());
        System.out.println(PrototypeHorse3.horseNo());
    }
}
