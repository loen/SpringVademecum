package com.andrzejpe.spring;

import com.andrzejpe.spring.aspect.Audience;
import com.andrzejpe.spring.concert.Performance;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * Created by jedrek on 2015-10-15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class AopXmlTest {
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

    @Test
    public void audienceShouldSingSongWithFoo(){
        performance.singSong("TestSong");
        assertEquals("TestSong", audience.getPlayedSong());
    }
}
