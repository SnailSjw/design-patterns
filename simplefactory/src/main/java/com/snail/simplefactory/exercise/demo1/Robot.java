package com.snail.simplefactory.exercise.demo1;

/**
 * 机器人类
 * @author : snail
 * @date : 2022-03-29 23:09
 **/
public class Robot extends Person{
    public Robot() {
        System.out.println("创造机器人");
    }

    @Override
    void getGender() {
        System.out.println("我是机器人");
    }
}
