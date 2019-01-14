# Aditum Cloud

Spring Cloud Center for Aditum. Aditum微服务架构中心. 

# Spring Cloud 框架下的微服务管理中心的搭建

|模块|功能|环境|端口号|
|---|---|---|---|
|Eureka-Server|服务注册中心服务端|生产|10001
|Gateway-Zuul|服务API网关服务|生产|10002
|Hystrix-Dashboard|服务状态监控器|生产-监控|10003
|Eureka-Client|服务注册中心客户端|测试Eureka注册服务|20001
|Consume-Service|服务消费者|测试微服务流程-调用服务|20002
|Produce-Service|服务生产者|测试微服务流程-提供服务|20003

## 启动流程

1. 启动 Eureka-Server 服务注册中心
2. 启动其他服务（顺序任意，但推荐先启动生产项目）
3. 浏览器输入 localhost:20002/consume/{任意字符串} 即可访问 Consume-Service 调用 Produce-Service 的返回结果
3. 输入localhost:10002/consume-service/consume/{string} 即可通过API网关访问 Consume-Service 调用 Produce-Service 的返回结果
4. 输入http://localhost:10003/hystrix 进入监控中心

## 需求分析

为Aditum微服务架构提供一个管理平台，首先采用单机云服务器部署，能够通过http维护管理所有的Aditum微服务

## Config服务配置客户端

采用Apollo实现配置中心服务端，替代springcloud-config，在此项目中不再进行config服务端实现。

apollo配置中心地址：云主机IP:8080

## Eureka服务注册中心

实现springcloud-eureka服务端，各个微服务通过http进行服务注册发现。

Eureka服务发现中心地址：http://通过APOLLO获取地址/eureka/ （默认为localhost）

## Hystrix DashBoard监控平台使用

引入相关依赖，启用 @EnableHystrixDashboard @EnableCircuitBreaker @EnableHystrix 三个注解，通过引入监控的项目，通过ip:port/hystrix 访问，然后输入 ip:port/hystrix.stream 进行监控

## Zuul API网关

API网关是一个服务器，可以说是进入系统的唯一节点，封装了内部系统的架构，并且提供了API给各个客户端。

负责请求转发、合成、协议转换。先网关，在负载均衡到对应的微服务。

将Feign类路径统一映射为API网关地址，在方法中映射不同的微服务的路径，从而实现API网关的统一请求管理。 

--------------------------------------------------------------

# 客户端

## Eureka客户端

启用注解 @EnableDiscoveryClient ，注册为客户端

## 服务调用

### HttpClient 调用

通过类RestTemplate进行服务调用，可使用 服务名/服务ip地址 进行REST接口调用

### Feign服务调用

通过 @EnableFeignClients 启用服务。通过 @FeignClient("服务名") 定义接口，通过注解方法进行远程调用。

## Ribbon负载均衡

通过在RestTemplate类上注解 @LoadBalanced 即可实现负载均衡（注解已包含在Eureka客户端中）

## Hystrix服务熔断

需要额外引入hystrix依赖，使用 @EnableCircuitBreaker 开启断路器功能

在远程调用方法上使用 @HystrixCommand(fallbackMethod = 断路方法名) 进行异常时逻辑处理

例如：func : {return "服务不可用，请稍后再试！"} 