package com.andrzejpe.spring.soundSystem.mediaPlayers;

import com.andrzejpe.spring.soundSystem.compactDisks.ExtendedCompactDisk;

/**
 * Created by jedrek on 2015-10-04.
 */
public class ExtendedAutowiredMediaPlayer implements ExtendedMediaPlayer {

    private ExtendedCompactDisk cd;

    public ExtendedAutowiredMediaPlayer(ExtendedCompactDisk cd) {
        this.cd = cd;
    }

    @Override
    public void extendedPlay() {
        cd.extendedPlay();
    }
}
