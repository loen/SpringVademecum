package com.andrzejpe.spring;

import com.andrzejpe.spring.config.SpelConfig;
import com.andrzejpe.spring.spel.ItemConsumerByConfig;
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
@ContextConfiguration(classes = SpelConfig.class)
public class SpelConfigTest {

    @Autowired
    ItemConsumerByConfig itemConsumerByConfig;

    @Test
    public void shouldSetName() {
        assertEquals("new_item", itemConsumerByConfig.getName());
    }
}
