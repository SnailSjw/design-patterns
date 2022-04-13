package com.snail.demo1.shallow;

import lombok.Getter;
import lombok.Setter;

/**
 * 周报
 *
 * @author : snail
 * @date : 2022-04-13 23:27
 **/
@Getter
@Setter

public class WeeklyLog implements Cloneable{
    private Attachment attachment;
    private String name;
    private String date;
    private String content;

    @Override
    public WeeklyLog clone(){
        Object object = null;
        try {
            object = super.clone();
            return (WeeklyLog) object;
        } catch (CloneNotSupportedException e) {
            System.out.println("不支持复制");
            return null;
        }
    }
}
