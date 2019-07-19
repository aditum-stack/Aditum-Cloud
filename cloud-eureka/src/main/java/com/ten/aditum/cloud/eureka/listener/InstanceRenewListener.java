package com.ten.aditum.cloud.eureka.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRenewedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;

/**
 * 服务心跳监听
 */
@Slf4j
@Configuration
public class InstanceRenewListener implements ApplicationListener<EurekaInstanceRenewedEvent> {
    @Override
    public void onApplicationEvent(EurekaInstanceRenewedEvent event) {
        if (log.isDebugEnabled()) {
            log.debug("服务[{}]更新心跳", event.getInstanceInfo().getAppName());
        }
    }
}
