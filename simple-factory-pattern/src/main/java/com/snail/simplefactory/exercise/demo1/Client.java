package com.snail.simplefactory.exercise.demo1;

/**
 * 测试类
 *
 * @author : snail
 * @date : 2022-03-29 23:04
 **/
public class Client {
    public static void main(String[] args) {
        Person m = NvwaFactory.createPerson("M");
        m.getGender();
        Person r = NvwaFactory.createPerson("R");
        r.getGender();
    }
}
