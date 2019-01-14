1. 引入apollo依赖并启用注解 @EnableApolloClient

<!--apollo配置中心客户端-->
<dependency>
    <groupId>com.ctrip.framework.apollo</groupId>
    <artifactId>apollo-client</artifactId>
</dependency>

2. appllication配置apollo命名空间(具体配置在apollo进行)

apollo:
  meta: http://47.106.11.84:8080
  bootstrap:
    enabled: true
    namespaces: application,ADITUM.xxx

3. 远程开发: 设置启动参数

-Dapollo.configService=http://47.106.11.84:8080