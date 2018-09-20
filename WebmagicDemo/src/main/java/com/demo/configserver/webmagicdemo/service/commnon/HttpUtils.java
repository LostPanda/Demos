package com.demo.configserver.webmagicdemo.service.commnon;

import lombok.experimental.UtilityClass;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @Author wb-hx347246
 * @Date 2018/8/21 下午1:37
 */
@UtilityClass
public class HttpUtils {

    public static String getCookie(String urlString){
        String cookie="";
        try {
            URL url = new URL(urlString);
            URLConnection urlConnection = url.openConnection();
            urlConnection.connect();
            cookie= urlConnection.getHeaderField("Cookie");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cookie;
    }
}
