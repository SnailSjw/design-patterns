package com.snail.factorymethod.demo1;

/**
 * 日志工厂抽象类
 *
 * @author : snail
 * @date : 2022-03-30 09:51
 **/
public interface LoggerFactory {

    /**
     * 创建日志
     * @return 日志抽象类
     */
    public Logger createLogger();
}
