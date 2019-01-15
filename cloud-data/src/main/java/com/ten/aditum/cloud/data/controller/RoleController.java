package com.ten.aditum.cloud.data.controller;

import com.ten.aditum.cloud.data.entity.SysRole;
import com.ten.aditum.cloud.data.service.RoleService;
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
 * Time: 10:27
 */
@RestController
@RequestMapping("role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping("getRoleByUserId/{userId}")
    public Result getRoleByUserId(@PathVariable("userId") Integer userId) {
        List<SysRole> roleList = roleService.getRoleByUserId(userId);
        return Result.ok().setData(roleList);
    }

}
