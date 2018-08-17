package com.demo.lombok.validate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author wb-hx347246
 * @Date 2018/8/17 下午1:38
 */
@Controller
public class UserController {

    @RequestMapping("/register")
    @ResponseBody
    public String register(@Validated User user){
        return "success";
    }
}
