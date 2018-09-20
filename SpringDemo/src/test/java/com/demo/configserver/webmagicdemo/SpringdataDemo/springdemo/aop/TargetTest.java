package com.demo.configserver.webmagicdemo.SpringdataDemo.springdemo.aop;

import com.demo.configserver.webmagicdemo.SpringdataDemo.springdemo.config.BeanCofig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BeanCofig.class)
public class TargetTest {
    @Autowired
    private TargetInterface target;

    @Test
    public void testMethod() {
        String s = null;

        s = target.testMethod(2, "hello");

        System.out.println(s);
    }

}