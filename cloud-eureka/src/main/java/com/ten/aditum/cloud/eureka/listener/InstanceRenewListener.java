package com.ten.aditum.cloud.eureka.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRenewedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;

/**
 * 服务心跳监听
 */
@Configuration
public class InstanceRenewListener implements ApplicationListener<EurekaInstanceRenewedEvent> {
    private static final Logger log = LoggerFactory.getLogger(InstanceRenewListener.class);

    @Override
    public void onApplicationEvent(EurekaInstanceRenewedEvent event) {
        log.info("心跳检测服务：{}", event.getInstanceInfo().getAppName());
    }
}
