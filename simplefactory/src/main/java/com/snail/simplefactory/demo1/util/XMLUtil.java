package com.snail.simplefactory.demo1.util;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * XML工具类
 *
 * @author : snail
 * @date : 2022-03-29 20:31
 **/
public class XMLUtil {
    public static String getChartType(){
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(new File("D:\\IdeaProjects\\design-pattern\\simplefactory\\src\\main\\resources\\args.xml"));//

            // 解析xml获取参数
            NodeList nodeList = document.getElementsByTagName("chartType");
            Node firstChild = nodeList.item(0).getFirstChild();
            return firstChild.getNodeValue().trim();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        return "";
    }
}
