package com.andrzejpe.spring.soundSystem;

import org.junit.Rule;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;

/**
 * Created by jedrek on 2015-10-04.
 */
public class BaseTest {
    //Really bad approach - you have to deal with special
    //characters and formatting.
    @Rule
    public final StandardOutputStreamLog log = new StandardOutputStreamLog();

    public final String lineSeparator = System.getProperty("line.separator");
}
