package com.andrzejpe.spring.soundSystem.config;

import com.andrzejpe.spring.soundSystem.compactDisks.ExtendedCompactDisk;
import com.andrzejpe.spring.soundSystem.compactDisks.Revolver;
import com.andrzejpe.spring.soundSystem.mediaPlayers.ExtendedAutowiredMediaPlayer;
import com.andrzejpe.spring.soundSystem.mediaPlayers.ExtendedMediaPlayer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by jedrek on 2015-10-04.
 */
@Configuration
@ComponentScan(basePackages = "com.andrzejpe.spring.soundSystem")
public class SoundSystemJavaConfig {


    @Bean(name = "revolver")
    public ExtendedCompactDisk revolver(){
        return new Revolver();
    }


    @Bean
    public ExtendedMediaPlayer extendedMediaPlayer(ExtendedCompactDisk cd) {
        return new ExtendedAutowiredMediaPlayer(cd);
    }
}
