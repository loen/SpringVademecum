package com.andrzejpe.spring;

import com.andrzejpe.spring.spel.ItemConsumer;
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
@ContextConfiguration("/spel.xml")
public class SpelXmlTest {

    @Autowired
    private ItemConsumer itemConsumer;

    @Test
    public void shouldGetProperItem(){
        assertEquals("item_name_test", itemConsumer.getConsumes());
    }
}
