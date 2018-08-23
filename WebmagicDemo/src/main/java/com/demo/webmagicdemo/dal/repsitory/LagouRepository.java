package com.demo.webmagicdemo.dal.repsitory;

import com.demo.webmagicdemo.dal.entity.JobPosition;
import org.quartz.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * @Author wb-hx347246
 * @Date 2018/8/21 下午7:04
 */
public interface LagouRepository extends JpaRepository<JobPosition,Long> {

     JobPosition findByJobdetailAndCompanynameAndJobnameAndSalary(String jobdetail,String companyname,String jobname,String salary);


}
