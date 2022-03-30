package com.snail.simplefactory.demo1;

/**
 * 饼状图
 *
 * @author : snail
 * @date : 2022-03-29 19:41
 **/
public class PieChart implements Chart {
    @Override
    public void display() {
        System.out.println("显示饼状图");
    }

    public PieChart() {
        System.out.println("创建饼状图");
    }
}
