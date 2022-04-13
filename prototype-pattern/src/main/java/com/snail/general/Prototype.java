package com.snail.general;

/**
 * 抽象原型类
 * 通用实现方法：
 *    在具体原型类的克隆方法中实例化一个与自身类型相同的代码并将其返回，同时将相关的参数传入新创建的对象中，保证他们的成员变量相同。
 *
 * @author : snail
 * @date : 2022-04-13 21:03
 **/
public abstract class Prototype {
    @Override
    public abstract Prototype clone();
}
