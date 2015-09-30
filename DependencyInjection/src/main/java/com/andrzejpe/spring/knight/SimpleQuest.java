package com.andrzejpe.spring.knight;

import java.io.PrintStream;

/**
 * Created by jedrek on 2015-09-30.
 */
public class SimpleQuest implements Quest {

    private PrintStream stream;

    public SimpleQuest(PrintStream stream) {
        this.stream = stream;
    }

    @Override
    public void embarkQuest() {
        stream.println("yey it's embarkQuest");
    }
}
