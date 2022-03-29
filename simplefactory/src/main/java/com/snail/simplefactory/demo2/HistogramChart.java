package com.snail.simplefactory.demo2;

/**
 * 柱状图
 *
 * @author : snail
 * @date : 2022-03-29 19:41
 **/
public class HistogramChart extends Chart {

    @Override
    public void display() {
        System.out.println("显示柱状图");
    }

    public HistogramChart() {
        System.out.println("创建柱状图");
    }
}
