package com.snail.simplefactory.demo1;

/**
 * 折线图
 *
 * @author : snail
 * @date : 2022-03-29 19:41
 **/
public class LineChart implements Chart {
    @Override
    public void display() {
        System.out.println("显示折线图");
    }

    public LineChart() {
        System.out.println("创建折线图");
    }
}
