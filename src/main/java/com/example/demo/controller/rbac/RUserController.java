package com.example.demo.controller.rbac;

import com.example.demo.entity.rbac.rbacUser;
import com.example.demo.mapper.rbac.RUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RUserController {
    @Autowired
    RUserMapper rUserMapper;

    @GetMapping("/rbac/user")
    public List query(){
        List<rbacUser> rbacUsers = rUserMapper.selectList(null);
        if(rbacUsers != null && !rbacUsers.isEmpty()){
            return rbacUsers;
        }
        return null;
    }

    @PostMapping("/rbac/user")
    public String add(rbacUser rbcauser){
        int i = rUserMapper.insert(rbcauser);
        if(i > 0){
            return "success";
        }
        return "fail";
    }

}
