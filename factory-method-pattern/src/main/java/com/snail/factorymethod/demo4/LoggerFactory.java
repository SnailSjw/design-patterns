package com.snail.factorymethod.demo4;

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

    /**
     * 在工厂中实现写日志的逻辑
     */
    public default void writeLog(){
        Logger logger = this.createLogger();
        logger.writeLog();
    }
}
