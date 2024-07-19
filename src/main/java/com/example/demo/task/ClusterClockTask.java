package com.example.demo.task;

import com.example.demo.entity.Task;
import com.example.demo.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@EnableScheduling
@Component
public class ClusterClockTask {
    @Autowired
    private TaskMapper taskMapper;
    @Scheduled(cron = "*/7 * * * * ?")
    public void clock() {
        Task task = taskMapper.selectByName("任务1");
        if (task != null) {
//            乐观锁解决冲突
            task.setTstatus("Active");
            int version = task.getTversion();
            task.setTversion(task.getTversion() + 1);
            int update = taskMapper.updateVersion(task.getTversion(),version,"任务1");
            if (update > 0) {
                System.out.println("任务1完成");
            }
        }
    }
}
