package com.andrzejpe.spring;

import com.andrzejpe.spring.config.RuntimePropertiesInjectionConfig;
import com.andrzejpe.spring.properties.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by jedrek on 2015-10-11.
 */
public class RuntimePropertiesMain {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(RuntimePropertiesInjectionConfig.class);
        Car car = ctx.getBean(Car.class);
        System.out.println(car.getName());
    }
}
