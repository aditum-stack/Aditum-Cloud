package com.ten.aditum.cloud.produce.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/produce")
public class ProduceController {

    @RequestMapping(value = "/{string}")
    @HystrixCommand(fallbackMethod = "consumefallback")
    public String consume(@PathVariable String string) {
        return "Produce服务调用成功！收到内容：" + string;
    }

    /**
     * 熔断方法：参数和返回值要相同
     */
    public String consumefallback(String string) {
        return "Produce服务调用失败，请稍后再试！收到内容：" + string;
    }
}
