package com.example.demo.entity;

import lombok.Data;

@Data
public class Task {
    private int tid;
    private String tname;
    private String tstatus;
    private int tversion;
}
