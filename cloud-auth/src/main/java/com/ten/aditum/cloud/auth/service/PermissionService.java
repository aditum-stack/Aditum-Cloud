package com.ten.aditum.cloud.auth.service;


import com.ten.aditum.cloud.auth.vo.MenuVo;
import com.ten.aditum.cloud.auth.vo.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "cloud-data", fallback = PermissionServiceFallback.class)
public interface PermissionService {

    @GetMapping("/permission/getRolePermission/{roleId}")
    Result<List<MenuVo>> getRolePermission(@PathVariable("roleId") Integer roleId);
}
