package com.snail.abstractfactory.demo1.factory;

import com.snail.abstractfactory.demo1.pojo.Button;
import com.snail.abstractfactory.demo1.pojo.ComboBox;
import com.snail.abstractfactory.demo1.pojo.TextField;

/**
 * 皮肤工厂类（抽象工厂）
 *
 * @author : snail
 * @date : 2022-03-30 16:10
 **/
public interface SkinFactory {
    /**
     * 创建按钮
     * @return 按钮
     */
    public Button createButton();

    /**
     * 创建TextField
     * @return 返回TextField
     */
    public TextField createTextField();

    /**
     * 创建comboBox
     * @return 返回comboBox
     */
    public ComboBox createComboBox();

}
