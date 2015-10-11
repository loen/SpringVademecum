package com.andrzejpe.spring;

import com.andrzejpe.spring.config.MultiProfilesInOneConfigConfig;
import com.andrzejpe.spring.data.DataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by jedrek on 2015-10-11.
 */
public class MultipleProfileOneConfig {

    public static void main(String[] args) {
        System.setProperty("spring.profiles.default", "dev");
        ApplicationContext context = new AnnotationConfigApplicationContext(MultiProfilesInOneConfigConfig.class);
        DataSource dsDev = (DataSource)context.getBean(DataSource.class);
        System.out.println(dsDev.getData());

        System.setProperty("spring.profiles.default", "sit");
        context = new AnnotationConfigApplicationContext(MultiProfilesInOneConfigConfig.class);
        DataSource dsSIT = (DataSource)context.getBean(DataSource.class);
        System.out.println(dsSIT.getData());
    }
}
