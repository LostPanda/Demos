package com.demo.webmagicdemo.SpringdataDemo.netty.echosever;

/**
 * @Author wb-hx347246
 * @Date 2018/5/16 10:44
 */
public class Main {

    public static void main(String[] args) throws Exception {
        int port = 10001;

        new EchoSever(port).start();
    }
}
