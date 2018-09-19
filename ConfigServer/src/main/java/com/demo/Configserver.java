package com.demo;/**
 * @Author:hexiao wb347246
 * @Description
 * @Date: $time$ $date$
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 *@Author wb-hx347246
 *@Date 2018/9/19 上午11:30
 */
@SpringBootApplication
@EnableConfigServer
public class Configserver {

    public static void main(String[] args) {
        SpringApplication.run(Configserver.class,args);
    }
}
