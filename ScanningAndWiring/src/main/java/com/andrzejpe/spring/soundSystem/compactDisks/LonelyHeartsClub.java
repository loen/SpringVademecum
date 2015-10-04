package com.andrzejpe.spring.soundSystem.compactDisks;

import org.springframework.stereotype.Component;

/**
 * Created by jedrek on 2015-10-04.
 */
@Component("lonelyHeartsClub")
public class LonelyHeartsClub implements CompactDisc {
    @Override
    public void play() {
        System.out.println("LonelyHeartsClub");
    }
}
