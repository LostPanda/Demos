package com.demo.configserver.webmagicdemo.service.crawler;

import com.demo.configserver.webmagicdemo.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import us.codecraft.webmagic.Site;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class LagouCrawlerTest {
    @Autowired
    private LagouCrawler lagouCrawler;
    @Resource
    Site lagouSite;
    @Test
    public void crawl() {
        try {
            System.out.println("lagousite:"+lagouSite);
            lagouCrawler.crawl("高级java",150,"杭州");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test(){
        System.out.println(new Date(System.currentTimeMillis()).toString());
    }

}