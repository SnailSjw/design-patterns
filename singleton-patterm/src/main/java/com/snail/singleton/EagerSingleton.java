package com.snail.singleton;

/**
 * 饿汉式
 *
 * @author : snail
 * @date : 2022-04-19 22:25
 **/
public class EagerSingleton {
    private static final EagerSingleton singleton = new EagerSingleton();

    private EagerSingleton() {}

    public static EagerSingleton getSingleton() {
        return singleton;
    }
}
