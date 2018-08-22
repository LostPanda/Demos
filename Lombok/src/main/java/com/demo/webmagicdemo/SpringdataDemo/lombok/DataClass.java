package com.demo.webmagicdemo.SpringdataDemo.lombok;

import com.sun.istack.internal.NotNull;
import lombok.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Date;

/**
 * @Author wb-hx347246
 * @Date 2018/8/17 上午10:25
 */
@Value
public class DataClass {
    @NotNull private int id;
    private String name;
    private Date brith;
    private boolean isAlive;

    @Synchronized
    public void cleanup() throws Exception {
        @Cleanup FileInputStream fis = new FileInputStream(new File("~/hello"));
    }
}
