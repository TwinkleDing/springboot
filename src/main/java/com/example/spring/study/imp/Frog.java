package com.example.spring.study.imp;

/**
 * @author TwinkleDing
 */
public class Frog  extends  Animal implements Swim{
    @Override
    public void eat() {

    }

    @Override
    public void swim() {
        System.out.println("蛙泳");
    }
}
