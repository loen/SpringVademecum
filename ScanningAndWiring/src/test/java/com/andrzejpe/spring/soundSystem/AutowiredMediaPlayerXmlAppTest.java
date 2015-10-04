package com.andrzejpe.spring.soundSystem;

import com.andrzejpe.spring.soundSystem.compactDisks.CompactDisc;
import com.andrzejpe.spring.soundSystem.mediaPlayers.MediaPlayer;
import junit.framework.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

/**
 * Created by jedrek on 2015-10-04.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/springBeans.xml"})
public class AutowiredMediaPlayerXmlAppTest extends BaseTest implements ApplicationContextAware {

    //Really bad approach - you have to deal with special
    //characters and formatting.
    @Rule
    public final StandardOutputStreamLog log = new StandardOutputStreamLog();

    private ApplicationContext context;

    @Test
    public void shouldGetLonelyHeartsClubXml() {
        CompactDisc lonelyHeartsClubXml = (CompactDisc) context.getBean("LonelyHeartsClubXml");
        assertNotNull(lonelyHeartsClubXml);
        lonelyHeartsClubXml.play();
        assertEquals("LonelyHeartsClub" + lineSeparator, log.getLog());
    }

    @Test
    public void shouldGetAutowiredMediaPlayerXml() {
        MediaPlayer autowiredMediaPlayerXml = (MediaPlayer) context.getBean("AutowiredMediaPlayerXml");
        autowiredMediaPlayerXml.play();
        assertEquals("LonelyHeartsClub" + lineSeparator , log.getLog());
    }

    @Test
    public void shouldGeAutowiredMediaPlayerCPath() {
        MediaPlayer AutowiredMediaPlayerCPath = (MediaPlayer) context.getBean("AutowiredMediaPlayerCPath");
        AutowiredMediaPlayerCPath.play();
        assertEquals("LonelyHeartsClub" + lineSeparator , log.getLog());
    }

    @Test
    public void shouldGetCompactDiskWithTracks() {
        CompactDisc cd = (CompactDisc) context.getBean("compactDiskWithTracks");
        cd.play();
        assertEquals("Nirvana Nevermind track 1 track 2 " + lineSeparator, log.getLog());
    }

    @Test
    public void shoudQuotsaPlay() {
        CompactDisc quotsa = (CompactDisc) context.getBean("propertyCompactDisk");
        quotsa.play();
        assertEquals("QUOTSA GO track 1 track 2 " + lineSeparator, log.getLog());
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
