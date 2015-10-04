package com.andrzejpe.spring.soundSystem;

import com.andrzejpe.spring.soundSystem.compactDisks.SgtPeppers;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by jedrek on 2015-10-04.
 */
public class SoundSystemWithJavaApp {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SoundSystemJavaConfig.class);

        CompactDisc cd = (CompactDisc)context.getBean(SgtPeppers.class);
        cd.play();
        CompactDisc cd2 = (CompactDisc) context.getBean("lonelyHeartsClub");
        cd2.play();
    }
}
