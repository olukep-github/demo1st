package com.example.demo.controller.rbac;

import com.example.demo.entity.rbac.rbacRolePermission;
import com.example.demo.mapper.rbac.RolePermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GrantRoleController {
    @Autowired
    RolePermissionMapper rolePermissionMapper;


    @GetMapping("/rbac/role/grant")
    public List query(){
        List<rbacRolePermission> rbacRolePermissions = rolePermissionMapper.selectList(null);
        return rbacRolePermissions;
    }

    @PostMapping("/rbac/role/grant")
    public String add(rbacRolePermission rbacRolePermission){
        int i = rolePermissionMapper.insert(rbacRolePermission);
        if(i>0){
            return "success";
        }
        return "fail";
    }
}
