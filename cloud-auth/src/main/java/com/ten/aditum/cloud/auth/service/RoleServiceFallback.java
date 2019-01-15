package com.ten.aditum.cloud.auth.service;

import com.ten.aditum.cloud.auth.vo.Result;
import com.ten.aditum.cloud.auth.vo.RoleVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceFallback implements RoleService {
    private static final Logger log = LoggerFactory.getLogger(RoleServiceFallback.class);

    @Override
    public Result<List<RoleVo>> getRoleByUserId(Integer userId) {
        log.info("调用{}失败", "getRoleByUserId");
        return Result.failure(100, "调用getRoleByUserId失败");
    }
}
