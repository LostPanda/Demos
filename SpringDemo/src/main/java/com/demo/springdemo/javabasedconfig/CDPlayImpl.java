package com.demo.springdemo.javabasedconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author wb-hx347246
 * @Date 2018/5/9 15:17
 */
@Component
public class CDPlayImpl implements CDPlayer{
    @Resource(name = "cd")
    private CD cd;



    public CDPlayImpl(){}

    public CDPlayImpl(CD cd){
        this.cd=cd;

    }
    @Override
    public void play() {
        System.out.println(cd.getMusicName());
    }

}
