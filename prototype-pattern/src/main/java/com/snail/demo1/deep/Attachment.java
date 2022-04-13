package com.snail.demo1.deep;

import java.io.Serializable;

/**
 * 附件类
 *
 * @author : snail
 * @date : 2022-04-13 23:26
 **/
public class Attachment implements Serializable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void download(){
        System.out.println("下载附件，文件名为" + name);
    }
}
