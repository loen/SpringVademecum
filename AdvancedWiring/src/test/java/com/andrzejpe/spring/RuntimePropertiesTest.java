package com.andrzejpe.spring;

import com.andrzejpe.spring.config.RuntimePropertiesInjectionConfig;
import com.andrzejpe.spring.properties.Car;
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
@ContextConfiguration(classes = RuntimePropertiesInjectionConfig.class)
public class RuntimePropertiesTest {
    @Autowired
    private Car car;

    @Test
    public void shouldGetTestHonda() {
        assertEquals("test_honda", car.getName());
    }
}
