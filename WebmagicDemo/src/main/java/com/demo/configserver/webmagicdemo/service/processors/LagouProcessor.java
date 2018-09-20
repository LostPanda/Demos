package com.demo.configserver.webmagicdemo.service.processors;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.demo.configserver.webmagicdemo.dal.entity.JobPosition;
import com.demo.configserver.webmagicdemo.service.commnon.DateUtils;
import lombok.extern.java.Log;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Json;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;

/**
 * @Author wb-hx347246
 * @Date 2018/8/21 上午9:26
 */
@Log
@Service
public class LagouProcessor implements PageProcessor {
    private static final String JOB_URL_PREFIEX = "https://www.lagou.com/jobs/";
    private static final String JOB_URL_POSTFIEX = ".html";
    private static final String JD_BLANK="[]";

    @Resource
    private Site lagouSite;

    @Override
    public void process(Page page) {
        log.info("start prcess page:"+page.getUrl());
        ArrayList<String> urls = null;
        try {
            findJobDetailUrl(page);
            log.info("main page");
        } catch (Exception e) {
            log.info("It's a job page:"+page.getUrl());
        }
        String jd = page.getHtml().xpath("//dd[@class='job_bt']/div/p/text()").all().toString();
        String salary = page.getHtml().xpath("//span[@class='salary']/text()").toString();
        String jobName = page.getHtml().xpath("//span[@class='name']/text()").toString();
        String companyName = page.getHtml().xpath("//h2[@class='fl']/text()").toString();
        String advantage = page.getHtml().xpath("//dd[@class='job-advantage']/p/text()").toString();
        Date publishDate= DateUtils.retriveLagouDate(page.getHtml().xpath("//p[@class='publish_time']/text()").toString());
        if (StringUtils.isBlank(companyName) || StringUtils.isBlank(jobName)) {
            page.setSkip(true);
        }
        JobPosition jp = new JobPosition();
        jp.setCompanyname(companyName)
                .setJobdetail(jd)
                .setSalary(salary)
                .setJobname(jobName)
                .setJobatrraction(advantage)
                .setPublishdate(publishDate);
        log.info("Items:"+JSON.toJSONString(jp));
        page.putField("jp", jp);
    }

    private void findJobDetailUrl(Page page) {
        ArrayList<String> urls;
        Json all = page.getJson();
        JSONObject parse = (JSONObject) JSON.parse(page.getRawText());
        JSONObject o = (JSONObject) parse.get("content");
        JSONObject positionResult = (JSONObject) o.get("positionResult");
        JSONArray result = (JSONArray) positionResult.get("result");
        urls = new ArrayList<>();
        for (Object ignored : result) {
            JSONObject position = (JSONObject) ignored;
            String posititonId = position.get("positionId").toString();
            urls.add(JOB_URL_PREFIEX + posititonId + JOB_URL_POSTFIEX);
        }
        log.info("urlListSize:"+urls.size());
        page.addTargetRequests(urls);
    }

    @Override
    public Site getSite() {
        return lagouSite;
    }

}
