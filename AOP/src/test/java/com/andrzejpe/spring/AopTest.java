package com.andrzejpe.spring;

import com.andrzejpe.spring.aspect.Audience;
import com.andrzejpe.spring.concert.Performance;
import com.andrzejpe.spring.config.AopConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by jedrek on 2015-10-15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AopConfig.class)
public class AopTest {

    @Autowired
    Performance performance;

    @Autowired
    Audience audience;

    @Test
    public void allAdvicesShouldBeExecuted(){
        performance.perform();
        assertTrue(audience.isBeer());
        assertTrue(audience.isCD());
        assertTrue(audience.isPopCorn());
        assertTrue(audience.isTShirt());
        assertTrue(audience.isGoodTimeBefore());
        assertTrue(audience.isGoodTimeAfter());
    }
}
