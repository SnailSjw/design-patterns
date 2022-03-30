package com.snail.simplefactory.exercise.demo2;

/**
 * 三角形
 *
 * @author : snail
 * @date : 2022-03-29 23:18
 **/
public class Triangle implements Shape{
    public Triangle() {
        System.out.println("创建三角形");
    }

    @Override
    public void draw() {
        System.out.println("绘制三角形");
    }

    @Override
    public void erase() {
        System.out.println("擦除三角形");
    }
}
