package com.snail.simplefactory.exercise.demo1;

/**
 * 男人
 *
 * @author : snail
 * @date : 2022-03-29 22:59
 **/
public class Man extends Person{

    public Man() {
        System.out.println("创造男人");
    }

    @Override
    void getGender() {
        System.out.println("我是男人");
    }
}
