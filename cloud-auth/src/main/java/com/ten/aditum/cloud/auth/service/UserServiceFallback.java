package com.ten.aditum.cloud.auth.service;

import com.ten.aditum.cloud.auth.vo.Result;
import com.ten.aditum.cloud.auth.vo.UserVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UserServiceFallback implements UserService {
    private static final Logger log = LoggerFactory.getLogger(UserServiceFallback.class);

    @Override
    public Result<UserVo> findByUsername(String username) {
        log.info("调用{}失败", "findByUsername");
        return Result.failure(100, "调用findByUsername接口失败");
    }
}
