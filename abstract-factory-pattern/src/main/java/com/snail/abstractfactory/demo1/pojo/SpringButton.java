package com.snail.abstractfactory.demo1.pojo;

/**
 * springbutton
 *
 * @author : snail
 * @date : 2022-03-30 16:24
 **/
public class SpringButton extends Button{
    @Override
    public void display() {
        System.out.println("浅绿色按钮");
    }
}
