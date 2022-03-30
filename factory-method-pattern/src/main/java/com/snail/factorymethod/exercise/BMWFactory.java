package com.snail.factorymethod.exercise;

/**
 * 奔驰车工厂（具体工厂类）
 *
 * @author : snail
 * @date : 2022-03-30 12:02
 **/
public class BMWFactory implements CarFactory{
    @Override
    public Car createCar() {
        System.out.println("制造宝马……");
        return new BenzCar();
    }
}
