package com.example.demo.controller.rbac;

import com.example.demo.entity.rbac.rbacPermission;
import com.example.demo.mapper.rbac.RPermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RPermissionController {
    @Autowired
    RPermissionMapper rPermissionMapper;

    @GetMapping("/rbac/permission")
    public List query(){
        List <rbacPermission> rbacPermissions= rPermissionMapper.selectList(null);
        return rbacPermissions;
    }

    @PostMapping("/rbac/permission")
    public String add(rbacPermission rbacPermission){
        int i=rPermissionMapper.insert(rbacPermission);
        if(i>0){
            return "success";
        }
        return "fail";
    }
}
