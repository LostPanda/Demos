package com.demo.webmagicdemo.service.commnon;

import org.junit.Test;
import org.springframework.util.Assert;

public class HttpUtilsTest {

    @Test
    public void getCookie() {
        String cookie = HttpUtils.getCookie("https://www.lagou.com/upload/ltm/oss.html?u=/&q=506&n=513&d=242&l=332&dns=0&p=1094&pi=44&qn=860&t=1534831354649");
        Assert.notNull(cookie,"cookie should not be null");
    }
}