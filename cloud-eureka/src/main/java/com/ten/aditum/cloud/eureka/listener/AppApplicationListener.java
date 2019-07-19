package com.ten.aditum.cloud.eureka.listener;

import com.ten.aditum.cloud.metric.EmailMetricUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;

import java.util.Date;

/**
 * Spring生命周期监听
 */
@Slf4j
public class AppApplicationListener implements ApplicationListener {
    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        if (applicationEvent instanceof ContextStartedEvent) {
            log.info("================:{}", "ContextStartedEvent");
            EmailMetricUtil.sendMail163("Eureka启动", new Date().toString());
        }
        if (applicationEvent instanceof ContextRefreshedEvent) {
            log.info("================:{}", "ContextRefreshedEvent");
            EmailMetricUtil.sendMail163("Eureka重新启动", new Date().toString());
        }
        if (applicationEvent instanceof ContextClosedEvent) {
            log.info("================:{}", "ContextClosedEvent");
            EmailMetricUtil.sendMail163("Eureka关闭", new Date().toString());
        }
        if (applicationEvent instanceof ContextStoppedEvent) {
            log.info("================:{}", "ContextStoppedEvent");
            EmailMetricUtil.sendMail163("Eureka关闭", new Date().toString());
        }
        if (applicationEvent instanceof ApplicationReadyEvent) {
            log.info("================:{}", "ApplicationReadyEvent");
        }
    }
}
