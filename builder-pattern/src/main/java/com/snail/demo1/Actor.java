package com.snail.demo1;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 角色
 *
 * @author : snail
 * @date : 2022-04-03 11:17
 **/
@Getter
@Setter
@ToString
public class Actor {
    private String type;
    private String sex;
    private String face;
    private String costume;
    private String hairstyle;
}
