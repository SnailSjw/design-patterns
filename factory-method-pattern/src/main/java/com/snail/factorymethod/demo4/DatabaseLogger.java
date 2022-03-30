package com.snail.factorymethod.demo4;

/**
 * 数据库日志实体
 *
 * @author : snail
 * @date : 2022-03-30 09:54
 **/
public class DatabaseLogger implements Logger {
    public DatabaseLogger() {
        System.out.println("初始化数据库日志组件");
    }

    @Override
    public void writeLog() {
        System.out.println("数据库中记录日志");
    }
}
