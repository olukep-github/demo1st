package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

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
    }

