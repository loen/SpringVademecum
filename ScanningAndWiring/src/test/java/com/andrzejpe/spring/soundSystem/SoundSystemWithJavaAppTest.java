package com.andrzejpe.spring.soundSystem;

import com.andrzejpe.spring.soundSystem.compactDisks.LonelyHeartsClub;
import com.andrzejpe.spring.soundSystem.compactDisks.SgtPeppers;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

import static junit.framework.TestCase.assertNotNull;

/**
 * Created by jedrek on 2015-10-04.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SoundSystemJavaConfig.class)
public class SoundSystemWithJavaAppTest implements ApplicationContextAware {

    private ApplicationContext context;

    @Inject
    private SgtPeppers sgtPepper;

    private LonelyHeartsClub lonelyHeartsClub;

    @Test
    public void sgtPepperShouldBeSet(){
        assertNotNull(sgtPepper);
    }

    @Test
    public void lonelyHeartsClubShouldBeSet(){
        lonelyHeartsClub = (LonelyHeartsClub)context.getBean("lonelyHeartsClub");
        assertNotNull(lonelyHeartsClub);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
