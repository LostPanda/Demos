package com.demo.webmagicdemo.service.commnon;

import lombok.extern.java.Log;
import org.apache.commons.lang3.StringUtils;
import org.assertj.core.util.DateUtil;
import org.jsoup.helper.DataUtil;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @Author wb-hx347246
 * @Date 2018/8/22 上午10:18
 */
@Validated
@Log
public class DateUtils {
    private static final String TODAY_TAG=":";

    public static Date retriveLagouDate(@NotNull String date) {
        if(StringUtils.isBlank(date)){
            return null;
        }
        String manipulateString=date.substring(0,date.indexOf(" "));
        if(manipulateString.contains(TODAY_TAG)){
            return DateUtil.now();
        }else if(manipulateString.contains("-")){
            return DateUtil.parse(date);
        }else {
            return org.apache.commons.lang3.time.DateUtils.addDays(DateUtil.now(),-Integer.valueOf(manipulateString.substring(0,1)));
        }



    }

}
