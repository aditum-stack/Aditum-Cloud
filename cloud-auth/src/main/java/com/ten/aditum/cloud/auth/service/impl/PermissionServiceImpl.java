package com.ten.aditum.cloud.auth.service.impl;

import com.ten.aditum.cloud.auth.service.PermissionService;
import com.ten.aditum.cloud.auth.vo.MenuVo;
import com.ten.aditum.cloud.auth.vo.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Mr.Yangxiufeng
 * Date: 2018-06-13
 * Time: 11:14
 */
@Service
public class PermissionServiceImpl implements PermissionService {
    private static final Logger log = LoggerFactory.getLogger(PermissionServiceImpl.class);

    @Override
    public Result<List<MenuVo>> getRolePermission(Integer roleId) {
        log.info("调用{}失败", "getRolePermission");
        return Result.failure(100, "调用getRolePermission失败");
    }
}
