package com.andrzejpe.spring.soundSystem.compactDisks;

/**
 * Created by jedrek on 2015-10-04.
 */
public class Revolver implements ExtendedCompactDisk {

    @Override
    public void extendedPlay() {
        System.out.println("Revolver");
    }
}
