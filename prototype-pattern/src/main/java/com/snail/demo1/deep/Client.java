package com.snail.demo1.deep;

import java.io.IOException;

/**
 * 测试类
 * 浅拷贝方式
 *
 * @author : snail
 * @date : 2022-04-13 23:30
 **/
public class Client {
    public static void main(String[] args) {
        WeeklyLog weeklyLog = new WeeklyLog();
        Attachment attachment = new Attachment();
        weeklyLog.setAttachment(attachment);
        WeeklyLog clone = null;
        try {
            clone = weeklyLog.deepCopy();
        } catch (IOException e) {
            System.err.println("克隆失败");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("周报是否相同：" + (clone == weeklyLog));
        System.out.println("附件是否相同：" + (attachment == clone.getAttachment()));
    }
}
