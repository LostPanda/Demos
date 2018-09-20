package com.demo.configserver.webmagicdemo.SpringdataDemo.lombok.validate;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.Date;
import java.util.List;

/**
 * @Author wb-hx347246
 * @Date 2018/8/17 下午1:32
 */
@Data
@NoArgsConstructor
public class User {
    @NotNull( groups = GroupA.class)
    private Integer id;
    @Length(max = 4, message = "2-4", min = 2)
    private String name;
    @Min(value = 0, message = "age must greater than 0")
    @Max(value = 130, message = "age must less than 130")
    private Integer age;
    @Past
    private Date dateOfBrith;
    @Size(min = 1)
    @Valid
    List<Account> accountList;

}
