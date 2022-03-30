package com.snail.abstractfactory.demo1.factory;

import com.snail.abstractfactory.demo1.pojo.*;

/**
 * Spring皮肤工厂(具体工厂）
 * @author : snail
 * @date : 2022-03-30 16:18
 **/
public class SpringSkinFactory implements SkinFactory {
    @Override
    public Button createButton() {
        System.out.println("创建Button");
        return new SpringButton();
    }

    @Override
    public TextField createTextField() {
        System.out.println("创建TextField");
        return new SpringTextField();
    }

    @Override
    public ComboBox createComboBox() {
        System.out.println("创建ComboBox");
        return new SptingComboBox();
    }
}
