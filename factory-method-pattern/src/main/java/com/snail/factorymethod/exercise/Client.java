package com.snail.factorymethod.exercise;

import com.snail.factorymethod.XMLUtil;

/**
 * 练习题：模拟制造车奔驰、宝马，使用工厂方法模式
 *
 * @author : snail
 * @date : 2022-03-30 12:04
 **/
public class Client {
    public static void main(String[] args) {
        CarFactory factory = (CarFactory) XMLUtil.getBean("benz");
        Car car = factory.createCar();
        car.drive();
    }
}
