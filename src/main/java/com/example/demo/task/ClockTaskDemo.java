package com.example.demo.task;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@EnableScheduling
//@Component
public class ClockTaskDemo {
    @Scheduled(cron = "*/10 * * * * ?")
    public void clockTask() {
        System.out.println("clockTask");
    }
}
