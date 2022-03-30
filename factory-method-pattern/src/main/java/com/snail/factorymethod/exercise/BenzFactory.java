package com.snail.factorymethod.exercise;

/**
 * 奔驰工厂类（具体工厂）
 * @author : snail
 * @date : 2022-03-30 12:03
 **/
public class BenzFactory implements CarFactory{
    @Override
    public Car createCar() {
        System.out.println("制造奔驰");
        return new BenzCar();
    }

}
