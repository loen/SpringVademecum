package com.andrzejpe.spring;

import com.andrzejpe.spring.conditional.ConditionalExample;
import com.andrzejpe.spring.config.ProfileConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

/**
 * Created by jedrek on 2015-10-11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ProfileConfig.class)
public class ConditionalBeanTest {

    private ApplicationContext ctx;

    @Test(expected = NoSuchBeanDefinitionException.class)
    public void shouldThrowBeanNotInitialised() {
        System.setProperty("spring.profiles.default", "dev");
        ApplicationContext ctx = new AnnotationConfigApplicationContext(ProfileConfig.class);
        ctx.getBean(ConditionalExample.class);
    }

    @Test
    public void shouldGetConditionalBean(){
        System.setProperty("com.andrzejpe.foo", "fighters");
        ctx = new AnnotationConfigApplicationContext(ProfileConfig.class);
        ConditionalExample condNotEmpty = ctx.getBean(ConditionalExample.class);
        assertEquals("I'm conditional", condNotEmpty.imConditional());
    }

}
