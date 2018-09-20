package com.demo.configserver.webmagicdemo.service.pipline;


import com.alibaba.fastjson.JSON;
import com.demo.configserver.webmagicdemo.dal.entity.JobPosition;
import com.demo.configserver.webmagicdemo.dal.repsitory.LagouRepository;
import lombok.extern.java.Log;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import javax.annotation.Resource;

/**
 * @Author wb-hx347246
 * @Date 2018/8/21 下午5:25
 */
@Service
@Log
public class Lagoupipline implements Pipeline {
    @Resource
    private LagouRepository lagouRepository;
    @Override
    public void process(ResultItems resultItems, Task task) {
        log.info("pipline receive request:"+ JSON.toJSONString(resultItems));
        JobPosition jp = resultItems.get("jp");
        if (StringUtils.isNotBlank(jp.getJobname())){
            JobPosition jpStored = lagouRepository.findByJobdetailAndCompanynameAndJobnameAndSalary(jp.getJobdetail(),jp.getCompanyname(),jp.getJobname(),jp.getSalary());
            log.info(jpStored==null?"note found"+jp.getCompanyname()+":"+jp.getJobname() : "found:"+jp.getCompanyname()+":"+jp.getJobname());
            if (jpStored==null){
                lagouRepository.save(jp);
            }else {
                jpStored.setPublishdate(jp.getPublishdate());
                jpStored.setJobatrraction(jp.getJobatrraction());
                jpStored.setPublishdate(jp.getPublishdate());
                jpStored.setJobname(jp.getJobname());
                jpStored.setSalary(jp.getSalary());
                jpStored.setCompanyname(jp.getCompanyname());
                jpStored.setAddress(jp.getAddress());
            }
        }else{
            log.info("jobname is null");
        }

    }
}
