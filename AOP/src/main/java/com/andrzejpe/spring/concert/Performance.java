package com.andrzejpe.spring.concert;

/**
 * Created by jedrek on 2015-10-15.
 */
public class Performance {

    public void perform(){
        System.out.println("Foo Fighters in Krakow Arena Bitch!!");
    }

    public void singSong(String title){
        System.out.println(String.format("Foo fighters plays: %s", title));
    }
}
