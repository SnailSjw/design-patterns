package com.snail.abstractfactory.demo1.pojo;

/**
 * spring testfield
 *
 * @author : snail
 * @date : 2022-03-30 16:26
 **/
public class SpringTextField extends TextField{
    @Override
    public void display() {
        System.out.println("绿色边框文本框");
    }
}
