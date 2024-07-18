package com.example.demo.entity;

import lombok.Data;

@Data
public class Scheduled {
    private int cronId;
    private String cronName;
    private String cron;
}
