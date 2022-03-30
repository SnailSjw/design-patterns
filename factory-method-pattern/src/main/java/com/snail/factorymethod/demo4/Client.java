package com.snail.factorymethod.demo4;

import com.snail.factorymethod.XMLUtil;

/**
 * 测试类
 * 日志记录器可以通过多种途径保存系统的运行日志，如通过文件记录，通过数据库记录。用户可以通过修改配置文件灵活的修改记录方式。
 * 工厂方法的隐藏：为了简化客户端的使用，对客户端隐藏工厂方法，直接使用工厂对象调用所创建的产品对象中的业务方法。
 *
 * @author : snail
 * @date : 2022-03-30 09:46
 **/
public class Client {
    public static void main(String[] args) {
        // 此处注意bean.xml配置文件中的class中配置的具体类以免出错。
        LoggerFactory factory = (LoggerFactory) XMLUtil.getBean("fileLogger");
        //此处直接用过工厂调用，而不是具体的客户端
        factory.writeLog();
    }
}