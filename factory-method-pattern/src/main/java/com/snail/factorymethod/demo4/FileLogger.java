package com.snail.factorymethod.demo4;

/**
 * 文件日志实体
 *
 * @author : snail
 * @date : 2022-03-30 09:53
 **/
public class FileLogger implements Logger {
    public FileLogger() {
        System.out.println("初始化文件日志");
    }

    @Override
    public void writeLog() {
        System.out.println("文件中写入日志……");
    }
}
