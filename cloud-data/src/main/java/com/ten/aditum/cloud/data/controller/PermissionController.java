package com.ten.aditum.cloud.data.controller;

import com.ten.aditum.cloud.data.entity.SysMenu;
import com.ten.aditum.cloud.data.service.PermissionService;
import com.ten.aditum.cloud.data.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Mr.Yangxiufeng
 * Date: 2018-06-13
 * Time: 10:28
 */
@RestController
@RequestMapping("permission")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;
    @GetMapping("getRolePermission/{roleId}")
    public Result getRolePermission(@PathVariable("roleId") Integer roleId){
        List<SysMenu> menuList = permissionService.getPermissionsByRoleId(roleId);
        return Result.ok().setData(menuList);
    }

}
