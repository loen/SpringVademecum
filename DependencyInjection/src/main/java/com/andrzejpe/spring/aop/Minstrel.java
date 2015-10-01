package com.andrzejpe.spring.aop;

import java.io.PrintStream;

/**
 * Created by jedrek on 2015-10-01.
 */
public class Minstrel {

    private PrintStream stream;

    public Minstrel(PrintStream stream) {
        this.stream = stream;
    }

    public void beforeQuest() {
        stream.println("Before quest");
    }

    public void afterQuest() {
        stream.println("After quest");
    }
}
