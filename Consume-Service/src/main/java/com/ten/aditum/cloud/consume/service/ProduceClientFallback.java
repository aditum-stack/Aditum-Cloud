package com.ten.aditum.cloud.consume.service;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

@Component
public class ProduceClientFallback implements ProduceClient {

    @Override
    public String produce(@PathVariable("string") String string) throws Exception {
        return "未发现Produce服务，启用Consume熔断，请求内容：" + string;
    }

}
