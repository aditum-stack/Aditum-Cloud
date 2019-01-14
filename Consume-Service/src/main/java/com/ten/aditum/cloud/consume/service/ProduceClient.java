package com.ten.aditum.cloud.consume.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Feign 服务调用: 转发到ZuulAPI网关
 */
@Service
@FeignClient(name = "cloud-gateway-zuul", fallback = ProduceClientFallback.class)
public interface ProduceClient {

    /**
     * 通过网关访问服务
     */
    @GetMapping("/produce-service/produce/{string}")
    String produce(@PathVariable("string") String string) throws Exception;

}
