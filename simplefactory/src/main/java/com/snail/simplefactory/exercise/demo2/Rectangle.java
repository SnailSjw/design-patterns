package com.snail.simplefactory.exercise.demo2;

/**
 * 矩形
 *
 * @author : snail
 * @date : 2022-03-29 23:18
 **/
public class Rectangle implements Shape{
    public Rectangle() {
        System.out.println("创建矩形");
    }

    @Override
    public void draw() {
        System.out.println("绘制矩形");
    }

    @Override
    public void erase() {
        System.out.println("擦除矩形");
    }
}
