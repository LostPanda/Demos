package com.demo.springdemo.javabasedconfig;

import com.demo.springdemo.config.BeanCofig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BeanCofig.class)
public class CDPlayImplTest {
    @Resource
    private CDPlayer cdPlayer;
    @Test
    public void play() throws Exception {
        assertNotNull(cdPlayer);
        cdPlayer.play();
    }

}