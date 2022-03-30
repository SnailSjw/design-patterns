package com.snail.simplefactory.demo2;


/**
 * 饼状图
 *
 * @author : snail
 * @date : 2022-03-29 19:41
 **/
public class PieChart extends Chart {
    @Override
    public void display() {
        System.out.println("显示饼状图");
    }

    public PieChart() {
        System.out.println("创建饼状图");
    }
}
