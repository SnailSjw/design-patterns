package com.snail.factorymethod.demo3;

import com.snail.factorymethod.demo1.DatabaseLogger;
import com.snail.factorymethod.demo1.Logger;

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

    @Override
    public Logger createLogger(Object obj) {
        if (obj.equals("conn")) {
            System.out.println("获取连接数据库参数");
        }
        return new DatabaseLogger();
    }
}
