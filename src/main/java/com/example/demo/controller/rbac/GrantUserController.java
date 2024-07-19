package com.example.demo.controller.rbac;

import com.example.demo.entity.rbac.rbacUserRole;
import com.example.demo.mapper.rbac.UserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GrantUserController {
    @Autowired
    private UserRoleMapper userRoleMapper;

    @GetMapping("/rbac/user/grant")
    public List query(){
        List<rbacUserRole> rbacUserRoles = userRoleMapper.selectList(null);
        return rbacUserRoles;
    }

    @PostMapping("/rbac/user/grant")
    public String add(rbacUserRole rbacUserRole){
        int i = userRoleMapper.insert(rbacUserRole);
        if(i>0){
            return "success";
        }
        return "fail";
    }
}
