package com.snail.simplefactory.exercise.demo1;

/**
 * 女人
 *
 * @author : snail
 * @date : 2022-03-29 22:59
 **/
public class Woman extends Person{
    public Woman() {
        System.out.println("创造女人");
    }

    @Override
    void getGender() {
        System.out.println("我是女人");
    }
}
