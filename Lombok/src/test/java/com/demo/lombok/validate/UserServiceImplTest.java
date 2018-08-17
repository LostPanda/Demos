package com.demo.lombok.validate;

import com.demo.lombok.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class UserServiceImplTest {
    @Autowired
    IUserService userService;

    @Test
    public void register() {
        User user = new User();
        user.setAge(10);
        userService.register(user,-100);
    }
}