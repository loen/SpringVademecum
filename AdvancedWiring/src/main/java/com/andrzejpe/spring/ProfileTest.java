package com.andrzejpe.spring;

import com.andrzejpe.spring.config.ProfileConfig;
import com.andrzejpe.spring.data.DataSource;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by jedrek on 2015-10-11.
 */
public class ProfileTest {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ProfileConfig.class);
        try {
            DataSource dataSource = context.getBean(DataSource.class);
            System.out.println("dataSource : " + dataSource);
        } catch (NoSuchBeanDefinitionException ex){
            System.out.println(ex.toString());
        }
        System.setProperty("spring.profiles.default", "dev");
        context = new AnnotationConfigApplicationContext(ProfileConfig.class);
        DataSource dataSourceTwo = context.getBean(DataSource.class);
        System.out.println("dataSourceTwo " + dataSourceTwo.getData());
    }
}
