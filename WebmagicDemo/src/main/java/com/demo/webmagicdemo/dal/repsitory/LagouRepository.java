package com.demo.webmagicdemo.dal.repsitory;

import com.demo.webmagicdemo.dal.entity.JobPosition;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author wb-hx347246
 * @Date 2018/8/21 下午7:04
 */
public interface LagouRepository extends JpaRepository<JobPosition,Long> {

}
