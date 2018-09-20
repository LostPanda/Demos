package com.demo.configserver.webmagicdemo.SpringdataDemo.lombok.validate;

import com.sun.xml.internal.ws.developer.StreamingAttachment;
import lombok.Data;

import javax.validation.constraints.Min;

/**
 * @Author wb-hx347246
 * @Date 2018/8/17 下午3:50
 */
@Data
public class Account {
    @Min(value = 0,message = "account id ")
    private int accountId;
}
