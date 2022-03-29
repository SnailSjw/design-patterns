package com.snail.simplefactory.exercise.demo1;

import cn.hutool.core.util.StrUtil;

/**
 * 简单工厂模式实现女娲造人
 *
 * @author : snail
 * @date : 2022-03-29 22:56
 **/
public class NvwaFactory {

    public static Person createPerson(String type){
        if (StrUtil.isEmpty(type)) {
            throw new RuntimeException("参数错误");
        }
        if ("M".equals(type)){
            System.out.println("初始化男人");
            return new Man();
        }else if ("W".equals(type)) {
            System.out.println("初始化女人");
            return new Woman();
        }else if ("R".equals(type)){
            System.out.println("初始化机器人");
            return new Robot();
        }else {
            throw new RuntimeException("参数有误");
        }
    }
}
