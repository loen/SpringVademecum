package com.andrzejpe.spring.soundSystem.apps;

import com.andrzejpe.spring.soundSystem.compactDisks.CompactDisc;
import com.andrzejpe.spring.soundSystem.compactDisks.ExtendedCompactDisk;
import com.andrzejpe.spring.soundSystem.compactDisks.LonelyHeartsClub;
import com.andrzejpe.spring.soundSystem.config.SoundSystemJavaConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by jedrek on 2015-10-04.
 */
public class SoundSystemWithJavaApp {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SoundSystemJavaConfig.class);

        CompactDisc cd = context.getBean(LonelyHeartsClub.class);
        cd.play();
        CompactDisc cd2 = (CompactDisc)context.getBean("lonelyHeartsClub");
        cd2.play();
        ExtendedCompactDisk cd3 = (ExtendedCompactDisk) context.getBean("revolver");
        cd3.extendedPlay();
    }
}
