package com.snail.simplefactory.demo2;

/**
 * 折线图
 *
 * @author : snail
 * @date : 2022-03-29 19:41
 **/
public class LineChart extends Chart {
    @Override
    public void display() {
        System.out.println("显示折线图");
    }

    public LineChart() {
        System.out.println("创建折线图");
    }
}
