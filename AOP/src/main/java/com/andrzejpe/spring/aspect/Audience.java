package com.andrzejpe.spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * Created by jedrek on 2015-10-15.
 */
@Aspect
public class Audience {

    private boolean isBeer;
    private boolean isPopCorn;
    private boolean isCD;
    private boolean isTShirt;
    private boolean isGoodTimeBefore;

    private boolean isGoodTimeAfter;
    private String playedSong;

    @Pointcut("execution(* com.andrzejpe.spring.concert.Performance.perform(..))")
    public void pointcut(){}

    @Before("execution(* com.andrzejpe.spring.concert.Performance.perform(..))")
    public void drinkBeer(){
        System.out.println("Drink beer");
        isBeer = true;
    }

    @Before("pointcut()")
    public void eatPopcorn(){
        System.out.println("Eat popcorn");
        isPopCorn = true;
    }

    @After("pointcut()")
    public void buyCd(){
        System.out.println("CD bought");
        isCD = true;
    }

    @After("execution(* com.andrzejpe.spring.concert.Performance.perform(..))")
    public void buyTShirt(){
        System.out.println("T-Shirt bought");
        isTShirt = true;
    }

    @Around("pointcut()")
    public void goodTime(ProceedingJoinPoint jp){
        try {
            System.out.println("Before Concert!!!!");
            isGoodTimeBefore = true;
            jp.proceed();
        } catch (Throwable throwable) {
            System.out.println("Grohl broke leg... not again!!!");
            throwable.printStackTrace();
        }
        System.out.println("After Concert !!!");
        isGoodTimeAfter = true;
    }

    @Before("execution(* com.andrzejpe.spring.concert.Performance.singSong(String)) && args(title)")
    public void peopleSingWithFoo(String title){
        System.out.println(String.format("Audience starts singing: %s", title));
        this.playedSong = title;
    }

    public boolean isBeer() {
        return isBeer;
    }

    public boolean isPopCorn() {
        return isPopCorn;
    }

    public boolean isCD() {
        return isCD;
    }

    public boolean isTShirt() {
        return isTShirt;
    }

    public boolean isGoodTimeAfter() {
        return isGoodTimeAfter;
    }

    public boolean isGoodTimeBefore() {
        return isGoodTimeBefore;
    }

    public String getPlayedSong() {
        return playedSong;
    }
}
