package com.demo.configserver.webmagicdemo.SpringdataDemo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

/**
 * @Author wb-hx347246
 * @Date 2018/5/11 14:49
 */
@SpringBootApplication
@EnableConfigServer
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }

    @Test
    public void test() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("d:/sql")));
        StringBuffer sb = new StringBuffer();
        String s="";
        while ((s=br.readLine())!=null){
            String replace = s.replace("vendor_price", "vendor_price_latest");
            sb.append(replace);
            sb.append("\r\n");
        }

        System.out.println(sb.toString());
        PrintStream printStream = new PrintStream("d:/target.txt");
        printStream.write(sb.toString().getBytes());
        br.close();
        printStream.close();
    }
}
