package com.example.demo.task;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.entity.Scheduled;
import com.example.demo.mapper.CronMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;


@EnableScheduling
//@Component
public class ClockdbTaskDemo implements SchedulingConfigurer {

    @Autowired
     CronMapper cronMapper;

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.addTriggerTask(
                () -> process(),triggerContext -> {
                    QueryWrapper <Scheduled> queryWrapper = new QueryWrapper<>();
                    queryWrapper.eq("cron_id","1");
                    String cron = cronMapper.selectOne(queryWrapper).getCron();
                    if(cron==null){
                        System.out.println("cron is null");
                    }
                    return new CronTrigger(cron).nextExecutionTime(triggerContext);
                }
        );
    }

    private void process(){
        System.out.println("clockdbtask");
    }
}
