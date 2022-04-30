package com.snail.singleton;

/**
 * 一般实现
 *
 * @author : snail
 * @date : 2022-04-29 21:17
 **/
public class Singleton {
    // 静态私有成员变量
    private static Singleton instance = null;

    // 私有构造方法
    private Singleton() {}

    // 静态工厂方法，返回唯一实例
    public static Singleton getInstance(){
        if (instance == null){
            instance = new Singleton();
        }
        return instance;
    }
}
