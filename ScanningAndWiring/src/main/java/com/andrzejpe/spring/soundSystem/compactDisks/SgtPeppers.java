package com.andrzejpe.spring.soundSystem.compactDisks;

import com.andrzejpe.spring.soundSystem.CompactDisc;
import org.springframework.stereotype.Component;

/**
 * Created by jedrek on 2015-10-04.
 */
@Component
public class SgtPeppers implements CompactDisc {
    @Override
    public void play() {
        System.out.println("The Beattles SgtPeppers!");
    }
}
