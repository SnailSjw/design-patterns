package com.snail.singleton;

/**
 * 懒汉式
 *
 * @author : snail
 * @date : 2022-04-19 22:27
 **/
public class LazySingleton {
    private static LazySingleton singleton = null;

    private LazySingleton() {}

    /**
     * 多个线程访问存在线程安全问题，synchronized加在方法上，保证多线程下的线程安全。但并发效率不高
     * @return
     */
    public static synchronized LazySingleton getSingleton() {
        if (singleton == null) {
            singleton = new LazySingleton();
        }
        return singleton;
    }
}
