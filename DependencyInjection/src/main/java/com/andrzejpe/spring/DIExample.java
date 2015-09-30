package com.andrzejpe.spring;

import com.andrzejpe.spring.knight.Knight;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class DIExample
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("SpringBeans.xml");

        Knight k = context.getBean(Knight.class);
        k.embark();
    }
}
