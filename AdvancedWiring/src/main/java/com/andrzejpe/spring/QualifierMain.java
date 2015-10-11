package com.andrzejpe.spring;

import com.andrzejpe.spring.config.QualifiedConfig;
import com.andrzejpe.spring.qualified.CandyShop;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by jedrek on 2015-10-11.
 */
public class QualifierMain {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(QualifiedConfig.class);
        CandyShop shop = ctx.getBean(CandyShop.class);
        System.out.println(shop.getDessertName());
    }
}

