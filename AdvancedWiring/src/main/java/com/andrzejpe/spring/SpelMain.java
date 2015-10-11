package com.andrzejpe.spring;

import com.andrzejpe.spring.config.SpelConfig;
import com.andrzejpe.spring.spel.ItemConsumer;
import com.andrzejpe.spring.spel.ItemConsumerByConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by jedrek on 2015-10-11.
 */
public class SpelMain {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spel.xml");
        ItemConsumer co = ctx.getBean(ItemConsumer.class);
        System.out.println(co.getConsumes());

        ctx = new AnnotationConfigApplicationContext(SpelConfig.class);
        ItemConsumerByConfig consumerByConfig = ctx.getBean(ItemConsumerByConfig.class);
        System.out.println(consumerByConfig.getName());
    }
}
