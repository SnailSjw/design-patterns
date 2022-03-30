package com.snail.factorymethod.exercise;

/**
 * 宝马车（具体产品）
 *
 * @author : snail
 * @date : 2022-03-30 12:00
 **/
public class BMWCar implements Car {
    public BMWCar() {
        System.out.println("初始化宝马");
    }

    @Override
    public void drive() {
        System.out.println("开宝马车兜风");
    }
}
