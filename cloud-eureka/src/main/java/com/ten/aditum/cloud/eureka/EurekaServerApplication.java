package com.ten.aditum.cloud.eureka;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import com.ten.aditum.cloud.eureka.listener.AppApplicationListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;

/**
 * Eureka服务注册发现中心
 */
@SpringBootApplication
@EnableEurekaServer
@EnableApolloConfig
public class EurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
    }

    @Bean
    public AppApplicationListener appApplicationListener() {
        return new AppApplicationListener();
    }
}
