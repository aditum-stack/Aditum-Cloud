package com.ten.aditum.cloud.auth.service;

import com.ten.aditum.cloud.auth.vo.MenuVo;
import com.ten.aditum.cloud.auth.vo.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceFallback implements PermissionService {
    private static final Logger log = LoggerFactory.getLogger(PermissionServiceFallback.class);

    @Override
    public Result<List<MenuVo>> getRolePermission(Integer roleId) {
        log.info("调用{}失败", "getRolePermission");
        return Result.failure(100, "调用getRolePermission失败");
    }
}