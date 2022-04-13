package com.snail.general;

/**
 * 具体原型类
 *
 * @author : snail
 * @date : 2022-04-13 21:07
 **/
public class ConcretePrototype extends Prototype{
    private String attr;

    public String getAttr() {
        return attr;
    }

    public void setAttr(String attr) {
        this.attr = attr;
    }

    @Override
    public Prototype clone() {
        Prototype prototype = new ConcretePrototype();
        ((ConcretePrototype) prototype).setAttr(this.attr);
        return prototype;
    }
}
