package com.snail.factorymethod.exercise;

/**
 * @author : snail
 * @date : 2022-03-30 12:01
 **/
public class BenzCar implements Car{
    public BenzCar() {
        System.out.println("初始化奔驰");
    }

    @Override
    public void drive() {
        System.out.println("开奔驰兜风");
    }
}
