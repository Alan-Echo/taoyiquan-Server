package com.microservices.auth.config;

import com.microservices.auth.handler.*;
import com.microservices.auth.server.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @description: Security配置
 * 
 * @date: 2020-11-12 12:25
 **/
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomizeAuthenticationEntryPoint authenticationEntryPoint;

    @Autowired
    private CustomizeAuthenticationSuccessHandler successHandler;

    @Autowired
    private CustomizeAuthenticationFailureHandler failureHandler;

    @Autowired
    private CustomizeLogoutSuccessHandler logoutSuccessHandler;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        // 设置默认的加密方式（强hash方式加密）
        return new BCryptPasswordEncoder();
    }


    @Bean
    public UserDetailsService userDetailsService() {
        //获取用户账号密码及权限信息
        return new UserDetailsServiceImpl();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //配置认证方式
        auth.userDetailsService(userDetailsService());
    }

//    @Override
//    public void configure(WebSecurity web) {
//        //对于在header里面增加token等类似情况，放行所有OPTIONS请求。
//        web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //http相关的配置，包括登入登出、异常处理、会话管理等
        http
        .authorizeRequests()
//                .antMatchers("/user/**").hasAuthority("query_user")
//                基于角色控制
//                .antMatchers("/admin/**").hasAnyRole("admin")
//                .antMatchers("/user/**").hasAnyRole("user")
        //登入
        .and()
                .formLogin()
                .loginPage("/v1/login")
                .permitAll()//允许所有用户
                .successHandler(successHandler)//登录成功处理逻辑
                .failureHandler(failureHandler)//登录失败处理逻辑
//        //登出
        .and().logout()
                .permitAll()//允许所有用户
                .logoutSuccessHandler(logoutSuccessHandler)//登出成功处理逻辑
                .deleteCookies("JSESSIONID")//登出之后删除cookie
                //异常处理(权限拒绝、登录失效等)
        .and().exceptionHandling().
                authenticationEntryPoint(authenticationEntryPoint)//匿名用户访问无权限资源时的异常处理
//                .accessDeniedHandler(accessDeniedHandler)//异常捕获
//                .authenticationEntryPoint(new JWTAuthenticationEntryPoint())
//        限制同一账号只能一个用户使用  会话管理
        .and().sessionManagement()
//                .maximumSessions(1)//同一账号同时登录最大用户数
//                .expiredSessionStrategy(sessionInformationExpiredStrategy)//会话信息过期策略会话信息过期策略(账号被挤下线)
        ;
        http.csrf().disable().cors()
                .and()
//                .addFilter(new JWTAuthenticationFilter(authenticationManager()))
//                .addFilter(new JWTAuthorizationFilter(authenticationManager()))
                // 不需要session
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        ;
//        http.addFilterBefore(securityInterceptor, FilterSecurityInterceptor.class);//增加到默认拦截链中
    }





}
