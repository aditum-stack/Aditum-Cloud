package com.ten.aditum.cloud.auth.service;

import com.ten.aditum.cloud.auth.vo.Result;
import com.ten.aditum.cloud.auth.vo.RoleVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@FeignClient(name = "cloud-data", fallback = RoleServiceFallback.class)
public interface RoleService {

    @GetMapping("/role/getRoleByUserId/{userId}")
    Result<List<RoleVo>> getRoleByUserId(@PathVariable("userId") Integer userId);
}
