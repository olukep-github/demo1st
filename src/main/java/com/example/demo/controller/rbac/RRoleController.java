package com.example.demo.controller.rbac;

import com.example.demo.entity.rbac.rbacRole;
import com.example.demo.mapper.rbac.RRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RRoleController {
    @Autowired
    RRoleMapper rRoleMapper;

    @GetMapping("/rbac/role")
    public List query(){
        List<rbacRole> rbacRoles=rRoleMapper.selectList(null);
        return rbacRoles;
    }

    @PostMapping("/rbac/role")
    public String add(rbacRole rbacRole){
        int i=rRoleMapper.insert(rbacRole);
        if(i>0){
            return "success";
        }
        return "fail";
    }
}
