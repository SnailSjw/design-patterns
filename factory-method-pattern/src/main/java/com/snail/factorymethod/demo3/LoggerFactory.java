package com.snail.factorymethod.demo3;

import com.snail.factorymethod.demo1.Logger;

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
     * 创建日志,default方法调用无参的重载方法，有特殊需求可覆盖该方法。
     * @return 日志抽象类
     */
    public default Logger createLogger(String args){
        return createLogger();
    }

    /**
     * 创建日志,default方法调用无参的重载方法，有特殊需求可覆盖该方法。
     * @return 日志抽象类
     */
    public default Logger createLogger(Object obj){
        return createLogger();
    }



}
