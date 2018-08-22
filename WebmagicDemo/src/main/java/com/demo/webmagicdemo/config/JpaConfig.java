package com.demo.webmagicdemo.config;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @Author wb-hx347246
 * @Date 2018/8/21 下午6:22
 */
@EnableJpaRepositories(basePackages = "com.demo.webmagicdemo.dal")
public class JpaConfig {
}
