package com.demo.configserver.webmagicdemo.dal.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author wb-hx347246
 * @Date 2018/8/21 下午5:41
 */
@Data
@Accessors(chain = true)
@Entity
@Table
public class JobPosition {
    @Id
    @GeneratedValue
    private Long id;
    @Basic
    private String jobname;
    @Basic
    private String jobdetail;
    @Basic
    private String salary;
    @Basic
    private String companyname;
    @Basic
    private String jobatrraction;
    @Basic
    private String address;
    @Basic
    private Date publishdate;
}
