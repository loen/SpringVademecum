package com.andrzejpe.spring.soundSystem;

import com.andrzejpe.spring.soundSystem.compactDisks.CompactDisc;
import com.andrzejpe.spring.soundSystem.compactDisks.ExtendedCompactDisk;
import com.andrzejpe.spring.soundSystem.compactDisks.LonelyHeartsClub;
import com.andrzejpe.spring.soundSystem.config.SoundSystemJavaConfig;
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
    private CompactDisc injectLonelyHeartsClub;

    private CompactDisc lonelyHeartsClub;

    private ExtendedCompactDisk revolver;

    @Test
    public void injectLonelyHeartsClubShouldBeSet(){
        assertNotNull(injectLonelyHeartsClub);
    }

    @Test
    public void lonelyHeartsClubShouldBeSet(){
        lonelyHeartsClub = (LonelyHeartsClub)context.getBean("lonelyHeartsClub");
        assertNotNull(lonelyHeartsClub);
    }

    @Test
    public void revolverShouldBeSet() {
        revolver = (ExtendedCompactDisk) context.getBean("revolver");
        assertNotNull(revolver);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
