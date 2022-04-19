package com.snail.singleton;

/**
 * 懒汉式：双重检查锁定
 *
 * @author : snail
 * @date : 2022-04-19 22:31
 **/
public class LazySingleton2 {
    // 此处增加volatile关键字
    private volatile static LazySingleton2 instance = null;

    private LazySingleton2() {}

    public static LazySingleton2 getInstance(){
        // 第一重判断
        if (instance == null) {
            // 锁定代码
            synchronized (LazySingleton2.class){
                // 第二重判断
                if (instance == null) {
                    // 创建单例
                    instance = new LazySingleton2();
                }
            }
        }
        return instance;
    }
}
