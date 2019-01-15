package com.ten.aditum.cloud.auth.service.impl;

import com.ten.aditum.cloud.auth.service.RoleService;
import com.ten.aditum.cloud.auth.vo.Result;
import com.ten.aditum.cloud.auth.vo.RoleVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Mr.Yangxiufeng
 * Date: 2018-06-13
 * Time: 11:06
 */
@Service
public class RoleServiceImpl implements RoleService {
    private static final Logger log = LoggerFactory.getLogger(RoleServiceImpl.class);

    @Override
    public Result<List<RoleVo>> getRoleByUserId(Integer userId) {
        log.info("调用{}失败", "getRoleByUserId");
        return Result.failure(100, "调用getRoleByUserId失败");
    }
}
