package com.demo.lombok.validate;

import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * @Author wb-hx347246
 * @Date 2018/8/17 下午1:55
 */

@Service
@Log
public class UserServiceImpl implements IUserService {
    @Override
    public int register(User user, int code) {
        System.out.println("service exe!");
        return 0;
    }
}
