package com.ten.aditum.cloud.eureka.listener;

import com.ten.aditum.cloud.metric.EmailMetricUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceCanceledEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;

/**
 * 服务关闭监听
 */
@Slf4j
@Configuration
public class InstanceCancelListener implements ApplicationListener<EurekaInstanceCanceledEvent> {
    @Override
    public void onApplicationEvent(@NonNull EurekaInstanceCanceledEvent event) {
        log.warn("服务[{}]挂掉", event.getAppName());
        EmailMetricUtil.sendMail163("服务挂掉", event.getAppName());
    }
}
