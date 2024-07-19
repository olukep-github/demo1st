package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Task;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface TaskMapper extends BaseMapper<Task> {
    @Select("select * from task where tname =#{name}")
    public Task selectByName(@Param("name") String name);
    @Update("update task set tversion=#{nversion} where tversion=#{oversion} and tname=#{name}")
    public int updateVersion(@Param("nversion")int nversion, @Param("oversion")int oversion,@Param("name") String name);
}
