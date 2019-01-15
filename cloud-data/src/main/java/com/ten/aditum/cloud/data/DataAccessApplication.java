package com.ten.aditum.cloud.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = {"com.ten.aditum.cloud.data.mapper"})
public class DataAccessApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataAccessApplication.class, args);
    }
}
