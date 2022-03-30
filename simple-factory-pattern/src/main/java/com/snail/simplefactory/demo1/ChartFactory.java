package com.snail.simplefactory.demo1;

import cn.hutool.core.util.StrUtil;

/**
 * 简单工厂类
 *
 * 设计一套图表库，展示不同外观的图表，通过设置不同参数即可得到不同类型的图表，而且可以较为方便扩展新图表。
 *
 * @author : snail
 * @date : 2022-03-29 19:35
 **/
public class ChartFactory {

    /**
     * 该方法与{@link com.snail.simplefactory.demo1.ChartFactory#getChart(String)}效果一致，写法不同而已。
     *
     * @param type 类型
     * @return 指定类型的Chart子类
     */
    public static Chart initChart(String type){
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

    public static Chart getChart(String type){
        Chart chart = null;
        if (StrUtil.isEmpty(type)){
            System.out.println("参数有误");
            throw new RuntimeException("参数有误");
        }
        switch (type) {
            case "HistogramChart" :
                chart = new HistogramChart();
                System.out.println("初始化柱状图");
                break;
            case "LineChart" :
                chart = new LineChart();
                System.out.println("初始化折线图");
                break;
            case "PieChart" :
                System.out.println("初始化饼状图");
                chart = new PieChart();
                break;
            default:
                throw new RuntimeException("参数有误，请检查！");
        }
        return chart;
    }
}
