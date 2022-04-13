package com.snail.java;

import com.snail.general.ConcretePrototype;
import com.snail.general.Prototype;

/**
 * 客户端测试
 *
 * @author : snail
 * @date : 2022-04-13 22:47
 **/
public class Client {
    public static void main(String[] args) {
        Prototype prototype = new ConcretePrototype();
        Prototype copy = prototype.clone();
    }
}
