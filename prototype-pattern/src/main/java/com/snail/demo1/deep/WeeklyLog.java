package com.snail.demo1.deep;

import lombok.Getter;
import lombok.Setter;

import java.io.*;

/**
 * 周报
 *
 * @author : snail
 * @date : 2022-04-13 23:27
 **/
@Getter
@Setter

public class WeeklyLog implements Serializable {
    private Attachment attachment;
    private String name;
    private String date;
    private String content;

    /**
     * 通过序列化实现深克隆
     * @return
     */
    public WeeklyLog deepCopy() throws IOException, ClassNotFoundException {
        ByteArrayOutputStream bao = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bao);
        oos.writeObject(this);

        // 讲对象从流中取出
        ByteArrayInputStream bis = new ByteArrayInputStream(bao.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return (WeeklyLog) ois.readObject();
    }
}
