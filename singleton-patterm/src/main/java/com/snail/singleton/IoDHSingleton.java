package com.snail.singleton;

/**
 * 静态内部类：通过IoDH(Initialization on Demand Holder)实现单例模式
 *  该方式的优点：
 *      1.代码简洁
 *      2.多线程安全问题由JVM保证，多线程性能不受影响
 *      3.属于懒汉式，在调用时才会加载
 *  缺点：
 *      Java语言相关，不通用。
 *
 * @author : snail
 * @date : 2022-04-19 22:40
 **/
public class IoDHSingleton {
    public IoDHSingleton() {}

    public static class HolderClass {
        private static final IoDHSingleton instance = new IoDHSingleton();
    }

    public static IoDHSingleton getInstance(){
        return HolderClass.instance;
    }
}
