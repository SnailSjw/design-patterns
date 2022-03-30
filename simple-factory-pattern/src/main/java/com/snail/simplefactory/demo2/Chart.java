package com.snail.simplefactory.demo2;

import cn.hutool.core.util.StrUtil;


/**
 * 简单工厂模式的简化：抽象类和工厂类合并，在抽象类中创建对象
 *
 * @author : snail
 * @date : 2022-03-29 21:22
 **/
public abstract class Chart {

    public static Chart getChart(String type){
        if (StrUtil.isEmpty(type)){
            throw new RuntimeException("参数有误");
        }
        if ("HistogramChart".equals(type)){
            System.out.println("初始化柱状图");
            return new HistogramChart();
        }else if ("LineChart".equals(type)){
            System.out.println("初始化折线图");
            return new LineChart();
        }else if ("PieChart".equals(type)){
            System.out.println("初始化饼状图");
            return new PieChart();
        }else {
            throw new RuntimeException("参数有误，请检查！");
        }
    }

    abstract void display();
}
