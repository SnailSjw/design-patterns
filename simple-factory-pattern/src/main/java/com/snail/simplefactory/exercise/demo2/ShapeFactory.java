package com.snail.simplefactory.exercise.demo2;

import cn.hutool.core.util.StrUtil;

/**
 * 工厂类
 *
 * @author : snail
 * @date : 2022-03-29 23:22
 **/
public class ShapeFactory {
    public static Shape getSharp(String type){
        if (StrUtil.isEmpty(type)){
            throw new UnsupportedShapeException("不支持的几何图形");
        }
        switch (type){
            case "Circle":
                System.out.println("初始化圆形");
                return new Circle();
            case "Rectangle":
                System.out.println("初始化矩形");
                return new Rectangle();
            case "Triangle":
                System.out.println("初始化三角形");
                return new Triangle();
            default:
                throw new UnsupportedShapeException("不支持的几何图形");
        }

    }
}
