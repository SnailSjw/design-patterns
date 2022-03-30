package com.snail.simplefactory.demo2;

import com.snail.simplefactory.demo1.util.XMLUtil;

/**
 * 测试简单工厂类简化版
 * @author : snail
 * @date : 2022-03-29 21:34
 **/
public class Client {
    public static void main(String[] args) {
        Chart chart = Chart.getChart(XMLUtil.getChartType());
        chart.display();
    }
}
