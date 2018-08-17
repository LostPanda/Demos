package com.demo.lombok.validate;

import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Min;

/**
 * @Author wb-hx347246
 * @Date 2018/8/17 下午1:55
 */
@Validated
public interface IUserService {
    @Validated(GroupA.class)
    int register(@Valid User user, @Min(value = 10,groups = {GroupA.class,GroupB.class})int code);
}
