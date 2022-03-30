package com.snail.abstractfactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * xml读取工具类
 * 读取配置文件，并通过反射获取到对象
 *
 * @author : snail
 * @date : 2022-03-30 10:40
 **/
public class XMLUtil {
    /**
     * 通过配置文件读取对应id的类，并通过反射创建对象。
     * @param id 配置文件中每一个bean的id
     * @return 类对应的一个实例
     */
    public static Object getBean(String id){
        try {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(new File("abstract-factory-pattern/src/main/resources/bean.xml"));
            NodeList nodeList = document.getElementsByTagName("bean");
            for (int i = 0; i < nodeList.getLength(); i++) {
                NamedNodeMap attributes = nodeList.item(i).getAttributes();
                Node nodeId = attributes.getNamedItem("id");
                if (nodeId.getNodeValue().equals(id)){
                    String clazzName = attributes.getNamedItem("class").getNodeValue();
                    Class clazz = Class.forName(clazzName);
                    return clazz.newInstance();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
