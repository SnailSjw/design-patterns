package com.snail.abstractfactory.demo1.factory;

import com.snail.abstractfactory.demo1.pojo.*;

/**
 * Summer皮肤工厂（具体工厂）
 *
 * @author : snail
 * @date : 2022-03-30 16:19
 **/
public class SummerSkinFactory implements SkinFactory{
    @Override
    public Button createButton() {
        System.out.println("创建Button");
        return new SummerButton();
    }

    @Override
    public TextField createTextField() {
        System.out.println("创建TextField");
        return new SummerTextField();
    }

    @Override
    public ComboBox createComboBox() {
        System.out.println("创建ComboBox");
        return new SummerComboBox();
    }
}
