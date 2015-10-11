package com.andrzejpe.spring;

import com.andrzejpe.spring.config.MultiProfilesInOneConfigConfig;
import com.andrzejpe.spring.data.DataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

/**
 * Created by jedrek on 2015-10-11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MultiProfilesInOneConfigConfig.class)
public class MultipleProfileOneConfigTest implements ApplicationContextAware {


    private ApplicationContext context;

    @Test
    public void shouldSwitchBeansAfterProfileChange(){
        System.setProperty("spring.profiles.default", "dev");
        ApplicationContext context = new AnnotationConfigApplicationContext(MultiProfilesInOneConfigConfig.class);
        DataSource dsDev = context.getBean(DataSource.class);
        assertEquals("DEV data", dsDev.getData());

        System.setProperty("spring.profiles.default", "sit");
        context = new AnnotationConfigApplicationContext(MultiProfilesInOneConfigConfig.class);
        DataSource dsSIT = context.getBean(DataSource.class);
        assertEquals("SIT data", dsSIT.getData());

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
