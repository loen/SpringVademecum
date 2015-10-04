package com.andrzejpe.spring.soundSystem;

import com.andrzejpe.spring.soundSystem.config.SoundSystemJavaConfig;
import com.andrzejpe.spring.soundSystem.mediaPlayers.ExtendedMediaPlayer;
import com.andrzejpe.spring.soundSystem.mediaPlayers.MediaPlayer;
import junit.framework.TestCase;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

/**
 * Created by jedrek on 2015-10-04.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SoundSystemJavaConfig.class)
public class AutowiredMediaPlayerAppTest {

    //Really bad approach - you have to deal with special
    //characters and formatting.
    @Rule
    public final StandardOutputStreamLog log = new StandardOutputStreamLog();

    private final String lineSeparator = System.getProperty("line.separator");
    @Autowired
    MediaPlayer mediaPlayer;

    @Autowired
    ExtendedMediaPlayer extendedMediaPlayer;

    @Test
    public void mediaPlayerShouldBeSet() {
        assertNotNull(mediaPlayer);
    }

    @Test
    public void lonelyHeartsClubShouldBePlayed(){
        mediaPlayer.play();
        assertEquals("LonelyHeartsClub" + lineSeparator , log.getLog());
    }

    @Test
    public void exMediaPlayerShouldBeSet(){
        assertNotNull(extendedMediaPlayer);
    }

    @Test
    public void revolverShouldBePlayed(){
        extendedMediaPlayer.extendedPlay();
        TestCase.assertEquals("Revolver" + lineSeparator, log.getLog());
    }
}
