package com.demo.configserver.webmagicdemo.dal.repsitory;

import com.demo.configserver.webmagicdemo.dal.entity.JobPosition;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author wb-hx347246
 * @Date 2018/8/21 下午7:04
 */
public interface LagouRepository extends JpaRepository<JobPosition,Long> {

     JobPosition findByJobdetailAndCompanynameAndJobnameAndSalary(String jobdetail,String companyname,String jobname,String salary);


}
