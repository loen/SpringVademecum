package com.andrzejpe.spring;

import com.andrzejpe.spring.properties.Car;
import com.andrzejpe.spring.properties.Motor;
import com.andrzejpe.spring.properties.Rower;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

/**
 * Created by jedrek on 2015-10-11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class RuntimeXmlPropertiesTest {

    @Autowired
    Motor motor;

    @Autowired
    Rower rower;


    @Test
    public void motorShouldBeKawasaki() {
        assertEquals("test_kawasaki", motor.getName());
    }

    @Test
    public void rowerShouldBeHonda3() {
        assertEquals("test_wigry3", rower.getName());
    }
}
