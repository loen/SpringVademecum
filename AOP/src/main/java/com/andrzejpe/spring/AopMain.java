package com.andrzejpe.spring;

import com.andrzejpe.spring.concert.Performance;
import com.andrzejpe.spring.config.AopConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by jedrek on 2015-10-15.
 */
public class AopMain {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);

        Performance performance = context.getBean(Performance.class);
        performance.perform();
    }
}
