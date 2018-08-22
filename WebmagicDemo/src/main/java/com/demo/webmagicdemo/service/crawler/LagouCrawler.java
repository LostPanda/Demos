package com.demo.webmagicdemo.service.crawler;

import com.demo.webmagicdemo.service.param.LagouParam;
import com.demo.webmagicdemo.service.pipline.Lagoupipline;
import com.demo.webmagicdemo.service.processors.LagouProcessor;
import lombok.extern.java.Log;
import org.apache.commons.codec.Encoder;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Spider;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Author wb-hx347246
 * @Date 2018/8/21 上午9:41
 */
@Service
@Log
public class LagouCrawler {
    @Resource
    private Lagoupipline lagoupipline;
    @Resource
    private LagouProcessor lagouProcessor;

    public void crawl(String keyword,int num,String city) throws UnsupportedEncodingException {
        if(num%LagouParam.LAGOU_PAGESIZE!=0){
            log.warning(num+"/15 is not 0");
            return;
        }
        Integer size = num/LagouParam.LAGOU_PAGESIZE;
        for (int i=0;i<num/LagouParam.LAGOU_PAGESIZE;i++) {
            Request request = new Request("https://www.lagou.com/jobs/positionAjax.json?px=default&city="+ URLEncoder.encode(city,"utf-8") +"E&needAddtionalResult=false");
            request.setMethod("POST");
            ArrayList<NameValuePair> nameValuePairs = new ArrayList<>();
            nameValuePairs.add(new BasicNameValuePair(LagouParam.REQUEST_PARAM1_FIRST,"true"));
            nameValuePairs.add(new BasicNameValuePair(LagouParam.LAGOU_PARAM2_PN,size+""));
            nameValuePairs.add(new BasicNameValuePair(LagouParam.LAGOU_PARAM3_KD,keyword));
            NameValuePair[] value =  nameValuePairs.toArray(new NameValuePair[]{});
            HashMap<String, Object> stringObjectHashMap = new HashMap<>();
            stringObjectHashMap.put("nameValuePair",value);
            request.setExtras(stringObjectHashMap);
            log.info("start to create crawler");
            Spider.create(lagouProcessor)
                    .addPipeline(lagoupipline)
                    .addRequest(request)
                    .thread(1)
                    .run();
        }
    }
}
