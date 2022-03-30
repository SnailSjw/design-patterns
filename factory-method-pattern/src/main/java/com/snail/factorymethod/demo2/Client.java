package com.snail.factorymethod.demo2;

import com.snail.factorymethod.demo1.Logger;
import com.snail.factorymethod.demo1.LoggerFactory;
import com.snail.factorymethod.XMLUtil;

/**
 * 测试类：通过xml配置读取，符合开闭原则
 * 日志记录器可以通过多种途径保存系统的运行日志，如通过文件记录，通过数据库记录。用户可以通过修改配置文件灵活的修改记录方式。
 *
 * @author : snail
 * @date : 2022-03-30 09:46
 **/
public class Client {
    public static void main(String[] args) {
        LoggerFactory factory = (LoggerFactory) XMLUtil.getBean("fileLogger");
        Logger logger = factory.createLogger();
        logger.writeLog();
    }
}