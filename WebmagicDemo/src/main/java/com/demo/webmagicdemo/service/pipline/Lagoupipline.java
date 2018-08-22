package com.demo.webmagicdemo.service.pipline;


import com.demo.webmagicdemo.dal.entity.JobPosition;
import com.demo.webmagicdemo.dal.repsitory.LagouRepository;
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
public class Lagoupipline implements Pipeline {
    @Resource
    private LagouRepository lagouRepository;
    @Override
    public void process(ResultItems resultItems, Task task) {
        JobPosition jp = resultItems.get("jp");
        if (StringUtils.isNotBlank(jp.getJobname())){
            lagouRepository.save(jp);
        }

    }
}
