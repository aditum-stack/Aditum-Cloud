package com.ten.aditum.cloud.data.service.impl;

import com.ten.aditum.cloud.data.entity.SysRole;
import com.ten.aditum.cloud.data.mapper.SysRoleMapper;
import com.ten.aditum.cloud.data.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Mr.Yangxiufeng
 * Date: 2018-05-10
 * Time: 20:28
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private SysRoleMapper roleMapper;

    @Override
    public List<SysRole> getRoleByUserId(Integer userId) {
        return roleMapper.getRoleByUserId(userId);
    }
}
