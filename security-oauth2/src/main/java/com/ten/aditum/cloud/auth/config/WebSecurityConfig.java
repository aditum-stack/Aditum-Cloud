package com.ten.aditum.cloud.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private

    /**
     * 配置Filter链
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    /**
     * 配置通过拦截器保护请求，默认所有HTTP请求都需要验证
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 关闭CSRF防护
        http
                // 开启默认登录页
                .formLogin()
                .and()
                .authorizeRequests().anyRequest().permitAll()
                .and()
                .csrf().disable();
    }

    /**
     * 配置user-detail服务，存储用户及其角色
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                // 内存存储
                .inMemoryAuthentication()
                // 添加用户
                .withUser("user")
                // 添加密码
                .password("password")
                // 添加权限（会自动添加"ROLE_"前缀）
                .roles("USER")

                .and()

                .withUser("admin")
                .password("password")
                .roles("USER", "ADMIN");
    }

    /**
     * 处理验证
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    /**
     * 处理返回的用户信息
     */
    @Bean
    @Override
    public UserDetailsService userDetailsServiceBean() throws Exception {
        return super.userDetailsServiceBean();
    }
}
