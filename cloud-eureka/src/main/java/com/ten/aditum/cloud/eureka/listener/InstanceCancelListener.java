package com.ten.aditum.cloud.eureka.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceCanceledEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;

/**
 * 服务关闭监听
 */
@Configuration
public class InstanceCancelListener implements ApplicationListener<EurekaInstanceCanceledEvent> {
    private static final Logger log= LoggerFactory.getLogger(InstanceRegisterListener.class);

    @Override
    public void onApplicationEvent(@NonNull EurekaInstanceCanceledEvent event) {
        log.info("服务:{}挂了", event.getAppName());
    }
}
