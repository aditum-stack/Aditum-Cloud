package com.ten.aditum.cloud.data.controller;

import com.ten.aditum.cloud.data.entity.SysUser;
import com.ten.aditum.cloud.data.service.UserService;
import com.ten.aditum.cloud.data.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Mr.Yangxiufeng
 * Date: 2018-06-13
 * Time: 10:27
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("findByUsername/{username}")
    public Result findByUsername(@PathVariable("username") String username) {
        SysUser user = userService.findByUsername(username);
        if (user == null) {
            return Result.failure(100, "用户不存在");
        }
        return Result.ok().setData(user);
    }
}
