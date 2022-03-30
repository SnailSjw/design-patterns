package com.snail.simplefactory.demo1;

/**
 * 柱状图
 *
 * @author : snail
 * @date : 2022-03-29 19:41
 **/
public class HistogramChart implements Chart {
    @Override
    public void display() {
        System.out.println("显示柱状图");
    }

    public HistogramChart() {
        System.out.println("创建柱状图");
    }
}
