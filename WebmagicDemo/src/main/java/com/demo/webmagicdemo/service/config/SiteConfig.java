package com.demo.webmagicdemo.service.config;

import com.demo.webmagicdemo.service.commnon.LagouHeaderGenerator;
import com.demo.webmagicdemo.service.commnon.LagouLoginHelper;
import org.apache.commons.lang3.RandomUtils;
import org.assertj.core.util.DateUtil;
import org.openqa.selenium.Cookie;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import us.codecraft.webmagic.Site;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author wb-hx347246
 * @Date 2018/8/21 下午1:21
 */
@Configuration
public class SiteConfig {

    @Bean
    public Site lagouSite(List<String> userAngenlist) {

        Set<Cookie> login = LagouLoginHelper.generateCookie();
        Site site = Site.me().setRetryTimes(3).setSleepTime(2000)
                .addHeader("accept", "application/json, text/javascript, */*; q=0.01")
                .addHeader("Accept-Encoding", "gzip, deflate, br")
                .addHeader("Accept-language", "zh-CN,zh;q=0.9")
                .addHeader("Connection", "keep-alive")
                .addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
//            .addHeader("Content-Length","23")
               /* .addHeader("Cookie", "JSESSIONID=" + LagouHeaderGenerator.getJsessionId() +
                        ";LGUID="+LagouHeaderGenerator.getLGUId() +
                        ";LGSID="+LagouHeaderGenerator.getLGUId() +
                        ";LGRID=" +LagouHeaderGenerator.getLGUId()+
                        ";SEARCH_ID="+LagouHeaderGenerator.getSearchId() +
                        ";user_trace_token="+LagouHeaderGenerator.getLGUId() +
                        " _ga=GA1.2.1622101.1534831656; _gid=GA1.2.1896895610.1534831656; " +
                        "Hm_lvt_4233e74dff0ae5bd0a3d81c6ccf756e6=1534831656; " +
                        "index_location_city=%E5%85%A8%E5%9B%BD; " +
                        "ab_test_random_num=0; hasDeliver=0; showExpriedIndex=1; showExpriedCompanyHome=1; showExpriedMyPublish=1; " +
                        "login=false; unick=\"\"; _putrc=\"\"; " +
                        "TG-TRACK-CODE=index_search; " +
                        "Hm_lpvt_4233e74dff0ae5bd0a3d81c6ccf756e6=1534908097; "
                )*/
                .addHeader("Origin", "https://www.lagou.com")
                .addHeader("Host", "www.lagou.com")
                .addHeader("Referer", "https://www.lagou.com/jobs/list_java?labelWords=&fromSearch=true&suginput=")
                .addHeader("User-Agent", userAngenlist.get(RandomUtils.nextInt(0,8)))
                .addHeader("X-Anit-Forge-Code", "0")
                .addHeader("X-Anit-Forge-Token", "none")
                .addHeader("X-Requested-With", "XMLHttpRequest");

        for (Cookie cookie : login) {
            site.addCookie(cookie.getName().toString(),cookie.getValue().toString());
        }

        return site;
    }

    @Bean
    @ConfigurationProperties("crawler.userangenlist")
    public List<String> userAngenlist(){
        return new ArrayList<String>();
    }
}
