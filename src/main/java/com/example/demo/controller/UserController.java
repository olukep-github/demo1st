package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.entity.Permission;
import com.example.demo.entity.User;
import com.example.demo.entity.UserPermission;
import com.example.demo.mapper.GrantUserMapper;
import com.example.demo.mapper.PermissionMapper;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private GrantUserMapper grantUserMapper;

    @Autowired
    private PermissionMapper permissionMapper;

    @GetMapping("/user")
    public List query(){

        List<User> users = userMapper.selectList(null);
        System.out.println(users);
        return users;
        }


    @PostMapping("/user")
    public String save(User user){
        int i = userMapper.insert(user);
        if(i>0){
            return "success";
        }else {
            return "fail";
        }
    }

    @DeleteMapping("/user/{id}")
    public String remove(@PathVariable int id){
        int i = userMapper.deleteById(id);
        if(i>0){
            return "success";
        }
        return "fail";
    }

    @PutMapping("/user")
    public String update(User user){
        int i = userMapper.updateById(user);
        if(i>0){
            return "success";
        }
        return "fail";
    }

    @GetMapping("/user/{id}")
    public User findById(@PathVariable int id){
        return userMapper.selectById(id);
    }

    @GetMapping("/user/grant/")
    public String grant(String name,String access){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",name);
        int uid = userMapper.selectOne(queryWrapper).getId();
        QueryWrapper<Permission> queryWrapper1 = new QueryWrapper<>();
        queryWrapper1.eq("access",access);
        int pid = permissionMapper.selectOne(queryWrapper1).getId();
            UserPermission grant=new UserPermission();
            grant.setPid(pid);
            grant.setUid(uid);
            int i = grantUserMapper.insert(grant);
            if(i>0){
                return "success";
            }
            return "fail";
    }

    @DeleteMapping("/user/grant")
    public String removeGrant(String name,String access){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",name);
        int uid = userMapper.selectOne(queryWrapper).getId();
        QueryWrapper<Permission> queryWrapper1 = new QueryWrapper<>();
        queryWrapper1.eq("access",access);
        int pid = permissionMapper.selectOne(queryWrapper1).getId();
        QueryWrapper<UserPermission> queryWrapper2 = new QueryWrapper<>();
        queryWrapper2.eq("pid",pid);
        queryWrapper2.eq("uid",uid);
        int i = grantUserMapper.delete(queryWrapper2);
        if(i>0){
            return "success";
        }
        return "fail";
    }

    @GetMapping("/test")
    public List test(){
        List<User> users = userMapper.FindAllUserAndPermission();
//        List<User> users = userMapper.getUserById(1);
        System.out.println(users);
        return users;
    }
    }


