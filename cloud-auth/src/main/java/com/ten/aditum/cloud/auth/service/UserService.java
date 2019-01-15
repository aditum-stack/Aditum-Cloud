package com.ten.aditum.cloud.auth.service;

import com.ten.aditum.cloud.auth.service.impl.UserServiceImpl;
import com.ten.aditum.cloud.auth.vo.Result;
import com.ten.aditum.cloud.auth.vo.UserVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by Mr.Yangxiufeng on 2017/12/27.
 * Time:15:12
 * ProjectName:Mirco-Service-Skeleton
 */
@FeignClient(name = "mss-upms", fallback = UserServiceImpl.class)
public interface UserService {
    @GetMapping("user/findByUsername/{username}")
    Result<UserVo> findByUsername(@PathVariable("username") String username);
}
