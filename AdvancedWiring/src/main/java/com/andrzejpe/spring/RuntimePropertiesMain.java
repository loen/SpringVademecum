package com.andrzejpe.spring;

import com.andrzejpe.spring.config.RuntimePropertiesInjectionConfig;
import com.andrzejpe.spring.properties.Car;
import com.andrzejpe.spring.properties.Motor;
import com.andrzejpe.spring.properties.Rower;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by jedrek on 2015-10-11.
 */
public class RuntimePropertiesMain {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(RuntimePropertiesInjectionConfig.class);
        Car car = ctx.getBean(Car.class);
        System.out.println(car.getName());

        ApplicationContext fileContext = new ClassPathXmlApplicationContext("beans.xml");
        Motor motor = fileContext.getBean(Motor.class);
        System.out.println(motor.getName());
        Rower rower = fileContext.getBean(Rower.class);
        System.out.println(rower.getName());
    }
}
