package com.andrzejpe.spring.soundSystem.mediaPlayers;

import com.andrzejpe.spring.soundSystem.compactDisks.CompactDisc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by jedrek on 2015-10-04.
 */
@Component
public class AutowiredMediaPlayer implements MediaPlayer {

    private CompactDisc cd;

    @Autowired
    public AutowiredMediaPlayer(CompactDisc cd) {
        this.cd = cd;
    }

    public void play(){
        cd.play();
    }
}
