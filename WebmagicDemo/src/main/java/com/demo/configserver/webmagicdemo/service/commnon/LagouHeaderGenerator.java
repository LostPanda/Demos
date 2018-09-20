package com.demo.configserver.webmagicdemo.service.commnon;

import lombok.experimental.UtilityClass;
import org.assertj.core.util.DateUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @Author wb-hx347246
 * @Date 2018/8/22 下午1:18
 */
@UtilityClass
public class LagouHeaderGenerator {
    private static SimpleDateFormat simpleDateFormat;
    private static Date date;
    public static final String SAPERETOR="-";

    static {
        simpleDateFormat=new SimpleDateFormat("yyyyMMddhhmss");
    }
    public String getJsessionId(){
        return "ABAAABAAAGGABC"+(UUID.randomUUID().toString().toUpperCase()).replace("-","");
    }

    public  String getLGUId(){
        return simpleDateFormat.format(DateUtil.now())+SAPERETOR+UUID.randomUUID();
    }

    public String getSearchId(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
