package com.demo.webmagicdemo.SpringdataDemo.lombok.validate;

import com.demo.webmagicdemo.SpringdataDemo.lombok.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class UserServiceImplTest {
    @Autowired
    IUserService userService;

    @Test
    public void register() {
        User user = new User();
        user.setAge(10);
        user.setId(null);
        userService.register(user,100);
    }
}