package com.snail.java;

import com.snail.general.Prototype;

/**
 * 具体原型类
 *
 * @author : snail
 * @date : 2022-04-13 21:13
 **/
public class ConcretePrototype implements Cloneable {
    @Override
    protected Prototype clone() {
        Object object = null;
        try {
            object = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return (Prototype) object;
    }
}
