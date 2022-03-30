package com.snail.factorymethod.demo4;

/**
 * 数据库日志工厂类
 *
 * @author : snail
 * @date : 2022-03-30 09:57
 **/
public class DatabaseLoggerFactory implements LoggerFactory {
    @Override
    public Logger createLogger() {
        System.out.println("创建数据库日志组件");
        return new DatabaseLogger();
    }
}
