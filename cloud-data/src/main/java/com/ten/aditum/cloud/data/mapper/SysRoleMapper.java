package com.ten.aditum.cloud.data.mapper;

import com.ten.aditum.cloud.data.entity.SysRole;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SysRoleMapper extends Mapper<SysRole> {
    @Select(value = "select role.* from sys_role role,sys_user_role ur where role.id=ur.role_id and ur.user_id=#{userId}")
    List<SysRole> getRoleByUserId(Integer userId);
}