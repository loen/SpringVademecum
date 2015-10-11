package com.andrzejpe.spring;

import com.andrzejpe.spring.config.PrototypeConfig;
import com.andrzejpe.spring.prototype.Horse;
import com.andrzejpe.spring.prototype.PrototypeHorse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by jedrek on 2015-10-11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PrototypeConfig.class)
public class PrototypeTest {

    @Autowired
    Horse horse1;
    @Autowired
    Horse horse2;

    @Autowired
    PrototypeHorse prototypeHorse1;

    @Autowired
    PrototypeHorse prototypeHorse2;



    @Test
    public void shouldBeTheSameHorse() {
        System.out.println(horse1.horseNo());
        System.out.println(horse2.horseNo());
        assertEquals(horse1, horse2);
    }

    @Test
    public void shouldBeNotTheSameHorse(){
        System.out.println(prototypeHorse1.horseNo());
        System.out.println(prototypeHorse2.horseNo());
       assertNotEquals(prototypeHorse1, prototypeHorse2);
    }
}
