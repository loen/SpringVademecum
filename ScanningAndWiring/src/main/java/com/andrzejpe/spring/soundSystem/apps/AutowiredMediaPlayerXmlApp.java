package com.andrzejpe.spring.soundSystem.apps;

import com.andrzejpe.spring.soundSystem.compactDisks.CompactDisc;
import com.andrzejpe.spring.soundSystem.mediaPlayers.AutowiredMediaPlayer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by jedrek on 2015-10-04.
 */
public class AutowiredMediaPlayerXmlApp {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("springBeans.xml");

        AutowiredMediaPlayer mediaPlayer = (AutowiredMediaPlayer)context.getBean("AutowiredMediaPlayerXml");
        mediaPlayer.play();

        AutowiredMediaPlayer mediaPlayerCname = (AutowiredMediaPlayer) context.getBean("AutowiredMediaPlayerCPath");
        mediaPlayerCname.play();

        CompactDisc nirvana = (CompactDisc) context.getBean("compactDiskWithTracks");
        nirvana.play();

        CompactDisc quotsa = (CompactDisc) context.getBean("propertyCompactDisk");
        quotsa.play();
    }
}
