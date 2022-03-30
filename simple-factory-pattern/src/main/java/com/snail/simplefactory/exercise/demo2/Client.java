package com.snail.simplefactory.exercise.demo2;

/**
 * 测试类
 *
 * @author : snail
 * @date : 2022-03-29 23:31
 **/
public class Client {
    public static void main(String[] args) {
        Shape circle = ShapeFactory.getSharp("Circle");
        circle.draw();
        circle.erase();
    }
}
