package com.ten.aditum.cloud.data.service.impl;

import com.ten.aditum.cloud.data.entity.SysMenu;
import com.ten.aditum.cloud.data.mapper.SysMenuMapper;
import com.ten.aditum.cloud.data.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Mr.Yangxiufeng
 * Date: 2018-06-13
 * Time: 10:12
 */
@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private SysMenuMapper menuMapper;
    @Override
    public List<SysMenu> getPermissionsByRoleId(Integer roleId) {
        return menuMapper.getPermissionsByRoleId(roleId);
    }
}
