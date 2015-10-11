package com.andrzejpe.spring;

import com.andrzejpe.spring.conditional.ConditionalExample;
import com.andrzejpe.spring.config.ProfileConfig;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by jedrek on 2015-10-11.
 */
public class ConditionalExampleMain {

    public static void main(String[] args) {
        System.setProperty("spring.profiles.default", "dev");
        ApplicationContext ctx = new AnnotationConfigApplicationContext(ProfileConfig.class);
        try{
            ConditionalExample cond = ctx.getBean(ConditionalExample.class);
            System.out.println("conditional " + cond);
        }catch (NoSuchBeanDefinitionException ex){
            System.out.println(ex);
        }
        System.setProperty("com.andrzejpe.foo", "fighters");
        ctx = new AnnotationConfigApplicationContext(ProfileConfig.class);
        ConditionalExample condNotEmpty = ctx.getBean(ConditionalExample.class);
        System.out.println("and then " + condNotEmpty.imConditional());
    }
}
