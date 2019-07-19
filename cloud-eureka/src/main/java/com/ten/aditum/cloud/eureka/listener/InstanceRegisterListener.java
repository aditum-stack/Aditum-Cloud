package com.ten.aditum.cloud.eureka.listener;

import com.ten.aditum.cloud.metric.EmailMetricUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRegisteredEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;

/**
 * 服务注册监听
 */
@Slf4j
@Configuration
public class InstanceRegisterListener implements ApplicationListener<EurekaInstanceRegisteredEvent> {
    @Override
    public void onApplicationEvent(@NonNull EurekaInstanceRegisteredEvent eurekaInstanceRegisteredEvent) {
        log.info("服务[{}]注册成功", eurekaInstanceRegisteredEvent.getInstanceInfo().getAppName());
        EmailMetricUtil.sendMail163("服务注册成功", eurekaInstanceRegisteredEvent.getInstanceInfo().getAppName());
    }
}
