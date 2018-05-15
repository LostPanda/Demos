package com.demo.springdemo.config;

import com.demo.springdemo.javabasedconfig.CD;
import com.demo.springdemo.javabasedconfig.CDPlayImpl;
import com.demo.springdemo.javabasedconfig.CDPlayer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author wb-hx347246
 * @Date 2018/5/9 15:15
 */
@Configuration
//@ComponentScan(basePackages = "com.demo.springdemo")
public class BeanCofig {

    @Bean(name = "cd")
    public CD helloworld(){
        CD cd = new CD();
        cd.setMusicName("yesterday once more");
        return cd;
    }

    @Bean
    public CDPlayer cdPlayer(CD cd){
        return new CDPlayImpl(cd);
    }
}
