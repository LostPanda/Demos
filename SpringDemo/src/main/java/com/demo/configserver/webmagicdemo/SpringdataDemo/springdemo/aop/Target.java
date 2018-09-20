package com.demo.configserver.webmagicdemo.SpringdataDemo.springdemo.aop;

import org.springframework.stereotype.Component;

/**
 * @Author wb-hx347246
 * @Date 2018/6/22 10:50
 */
@Component
public class Target implements TargetInterface{
    @Override
    public String testMethod(Integer i, String s) {
        System.out.println("testMethod Exe");
//        throw new IllegalArgumentException("hello world");
        return s+i;
    }
}
