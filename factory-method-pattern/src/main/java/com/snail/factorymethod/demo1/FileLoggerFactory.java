package com.snail.factorymethod.demo1;

/**
 * 文件日志工厂类
 *
 * @author : snail
 * @date : 2022-03-30 09:55
 **/
public class FileLoggerFactory implements LoggerFactory {
    @Override
    public Logger createLogger() {
        System.out.println("创建文件日志组件");
        return new FileLogger();
    }
}
