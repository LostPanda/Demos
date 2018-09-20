package com.demo.configserver.webmagicdemo;

import static org.junit.Assert.assertTrue;

import lombok.extern.java.Log;
import org.assertj.core.util.DateUtil;
import org.junit.Test;

import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Unit test for simple App.
 */
@Log
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        SimpleDateFormat yYmmDDHHMMSS = new SimpleDateFormat("yyyyMMddHHmmss");
//        System.out.println(yYmmDDHHMMSS.format(new Date(System.currentTimeMillis())));
//        System.out.println(UUID.randomUUID());
//        System.out.println(URLEncoder.encode("高级java"));
        String s ="s s";
//        System.out.println(s.indexOf(" "));
//        System.out.println(DateUtil.parse("2018-09-01"));
        String replace="{&quot;regional&quot;:{&quot;asia-pacific-east&quot;:0.017,&quot;asia-pacific-southeast&quot;:0.0135,&quot;australia-central&quot;:0.02,&quot;australia-central-2&quot;:0.02,&quot;australia-east&quot;:0.016,&quot;australia-southeast&quot;:0.016,&quot;brazil-south&quot;:0.018,&quot;canada-central&quot;:0.012,&quot;canada-east&quot;:0.013,&quot;central-india&quot;:0.014,&quot;europe-north&quot;:0.012,&quot;europe-west&quot;:0.0126,&quot;france-central&quot;:0.0132,&quot;france-south&quot;:0.01716,&quot;germany-central&quot;:0.0075,&quot;germany-northeast&quot;:0.0075,&quot;japan-east&quot;:0.016,&quot;japan-west&quot;:0.016,&quot;korea-central&quot;:0.014,&quot;korea-south&quot;:0.013,&quot;south-india&quot;:0.015,&quot;united-kingdom-south&quot;:0.014,&quot;united-kingdom-west&quot;:0.014,&quot;us-central&quot;:0.013,&quot;us-east&quot;:0.0108,&quot;us-east-2&quot;:0.011,&quot;usgov-texas&quot;:0.015,&quot;us-north-central&quot;:0.012,&quot;us-south-central&quot;:0.013,&quot;us-west&quot;:0.014,&quot;us-west-2&quot;:0.012,&quot;us-west-central&quot;:0.013,&quot;west-india&quot;:0.015}}";
        String replace1 = replace.replace("&quot;", "\"");
        System.out.println(replace1);
    }
}
