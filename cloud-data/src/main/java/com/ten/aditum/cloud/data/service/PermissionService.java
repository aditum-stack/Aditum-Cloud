package com.ten.aditum.cloud.data.service;

import com.ten.aditum.cloud.data.entity.SysMenu;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Mr.Yangxiufeng
 * Date: 2018-06-13
 * Time: 10:12
 */
public interface PermissionService {
    List<SysMenu> getPermissionsByRoleId(Integer roleId);
}
