package com.demo.configserver.webmagicdemo.service.quatz;

import com.demo.configserver.webmagicdemo.service.commnon.HttpUtils;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Site;

import javax.annotation.Resource;

/**
 * @Author wb-hx347246
 * @Date 2018/8/21 下午1:34
 */
@Configurable
@Component
@EnableScheduling
public class CrawSechuler {
    @Resource
    private Site lagouSite;
    @Value("site.lagou.homepage")
    private String lagouHomepage;
    @Scheduled(cron = "0 0 2 * * ?")
    public void resetLagouCookie(){
        String cookie = HttpUtils.getCookie(lagouHomepage);
        lagouSite.addHeader("Cookie",cookie);

    }
}
