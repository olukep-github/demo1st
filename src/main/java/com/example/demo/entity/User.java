package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.List;

@Data
public class User {
    private int id;
    private String username;
    private String password;
    private String birthday;

    @TableField(exist = false)
    private List<Permission> permissions;
}
