package com.ten.aditum.cloud.eureka.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRegisteredEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;

/**
 * 服务注册监听
 */
@Configuration
public class InstanceRegisterListener implements ApplicationListener<EurekaInstanceRegisteredEvent> {
    private static final Logger log = LoggerFactory.getLogger(InstanceRegisterListener.class);

    @Override
    public void onApplicationEvent(@NonNull EurekaInstanceRegisteredEvent eurekaInstanceRegisteredEvent) {
        log.info("服务：{}，注册成功了", eurekaInstanceRegisteredEvent.getInstanceInfo().getAppName());
    }
}
