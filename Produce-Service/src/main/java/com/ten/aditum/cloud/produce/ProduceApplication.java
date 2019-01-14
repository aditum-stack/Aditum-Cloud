package com.ten.aditum.cloud.produce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 测试 服务生产者
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
public class ProduceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProduceApplication.class, args);
    }
}
