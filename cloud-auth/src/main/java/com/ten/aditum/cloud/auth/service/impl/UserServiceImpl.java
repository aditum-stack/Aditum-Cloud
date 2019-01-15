package com.ten.aditum.cloud.auth.service.impl;

import com.ten.aditum.cloud.auth.service.UserService;
import com.ten.aditum.cloud.auth.vo.Result;
import com.ten.aditum.cloud.auth.vo.UserVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Mr.Yangxiufeng
 * Date: 2018-06-13
 * Time: 10:56
 */
@Service
public class UserServiceImpl implements UserService {
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public Result<UserVo> findByUsername(String username) {
        log.info("调用{}失败", "findByUsername");
        return Result.failure(100, "调用findByUsername接口失败");
    }
}
