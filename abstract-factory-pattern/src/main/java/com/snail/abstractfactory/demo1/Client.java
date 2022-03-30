package com.snail.abstractfactory.demo1;

import com.snail.abstractfactory.XMLUtil;
import com.snail.abstractfactory.demo1.factory.SkinFactory;

/**
 * 客户端
 *
 *
 * @author : snail
 * @date : 2022-03-30 16:21
 **/
public class Client {
    public static void main(String[] args) {
        SkinFactory factory = (SkinFactory) XMLUtil.getBean("spring");
        factory.createButton().display();

        factory.createComboBox().display();
        factory.createTextField().display();
    }

}
