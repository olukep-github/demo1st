package com.example.demo.mapper.rbac;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.rbac.rbacUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RUserMapper extends BaseMapper <rbacUser>{
}
