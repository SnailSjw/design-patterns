package com.snail.factorymethod.exercise;

/**
 * car工厂类（抽象工厂）
 *
 * @author : snail
 * @date : 2022-03-30 11:56
 **/
public interface CarFactory {

    /**
     * 建造汽车
     * @return 抽象汽车类
     */
    public Car createCar();
}
