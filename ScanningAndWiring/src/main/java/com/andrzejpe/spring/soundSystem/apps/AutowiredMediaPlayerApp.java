package com.andrzejpe.spring.soundSystem.apps;

import com.andrzejpe.spring.soundSystem.mediaPlayers.ExtendedAutowiredMediaPlayer;
import com.andrzejpe.spring.soundSystem.mediaPlayers.ExtendedMediaPlayer;
import com.andrzejpe.spring.soundSystem.mediaPlayers.MediaPlayer;
import com.andrzejpe.spring.soundSystem.config.SoundSystemJavaConfig;
import com.andrzejpe.spring.soundSystem.mediaPlayers.AutowiredMediaPlayer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by jedrek on 2015-10-04.
 */
public class AutowiredMediaPlayerApp {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SoundSystemJavaConfig.class);
        MediaPlayer mp = context.getBean(AutowiredMediaPlayer.class);
        mp.play();
        ExtendedMediaPlayer exMp = context.getBean(ExtendedAutowiredMediaPlayer.class);
        exMp.extendedPlay();
    }
}
