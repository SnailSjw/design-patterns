package com.snail.simplefactory.demo1;

import com.snail.simplefactory.demo1.util.XMLUtil;

/**
 * 测试类
 *
 * @author : snail
 * @date : 2022-03-29 19:45
 **/
public class Client {
    public static void main(String[] args) {
        // Chart chart = ChartFactory.getChart("HistogramChart");
        // chart.display();
        // Chart chart2 = ChartFactory.initChart("LineChart");
        // chart2.display();

        // 通过xml配置方式传参
        Chart chart = ChartFactory.getChart(XMLUtil.getChartType());
        chart.display();
    }
}
