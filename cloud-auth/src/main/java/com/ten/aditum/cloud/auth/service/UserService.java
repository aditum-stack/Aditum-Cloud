package com.ten.aditum.cloud.auth.service;

import com.ten.aditum.cloud.auth.vo.Result;
import com.ten.aditum.cloud.auth.vo.UserVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@FeignClient(name = "cloud-data", fallback = UserServiceFallback.class)
public interface UserService {

    @GetMapping("/user/findByUsername/{username}")
    Result<UserVo> findByUsername(@PathVariable("username") String username);
}
