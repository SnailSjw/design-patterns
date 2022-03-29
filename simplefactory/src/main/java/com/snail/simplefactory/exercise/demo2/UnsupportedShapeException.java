package com.snail.simplefactory.exercise.demo2;

/**
 * 形状异常类
 *
 * @author : snail
 * @date : 2022-03-29 23:23
 **/
public class UnsupportedShapeException extends RuntimeException{
    public UnsupportedShapeException(String message) {
        super(message);
    }
}
