package com.qingqi.taoyiquan.gateway.config;

import com.qingqi.taoyiquan.gateway.config.handler.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.ReactiveAuthenticationManagerAdapter;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.authentication.AuthenticationWebFilter;
import org.springframework.web.server.WebFilter;

import java.util.Iterator;

/**
 * @description: security配置
 * @author: ※狗尾巴草
 * @date: 2020-11-26 12:01
 **/
@EnableWebFluxSecurity
public class SecurityConfig {
    @Autowired
    private CustomizeAuthenticationEntryPoint authenticationEntryPoint;

    //security的鉴权排除的url列表
    private static final String[] excludedAuthPages = {
            "/auth/api-auth/v1/login",
            "/auth/api-auth/v1/logout",
    };

    @Bean
    SecurityWebFilterChain securityFilterChain(ServerHttpSecurity http){
        http
                .authorizeExchange()
                // 需要权限访问de接口
                .pathMatchers("/admin/**","/user/api-user/*/admin/**").access(new XTReactiveAuthorizationManager("admin"))
                .pathMatchers("/user/api-user/*/api/**").access(new XTReactiveAuthorizationManager("admin","user"))

                //无需权限访问
//                .pathMatchers(excludedAuthPages).permitAll()  //无需进行权限过滤的请求路径
//                .pathMatchers(HttpMethod.OPTIONS).permitAll() //option 请求默认放行
                .anyExchange().permitAll()//无需权限访问

                .and()
                .httpBasic()
//                .authenticationEntryPoint()
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(authenticationEntryPoint)// 匿名访问

                .and() .csrf().disable()//必须支持跨域
                .logout().disable()
        ;

        SecurityWebFilterChain chain = http.build();
        Iterator<WebFilter> weIterable = chain.getWebFilters().toIterable().iterator();
        while(weIterable.hasNext()) {
            WebFilter f = weIterable.next();
            if(f instanceof AuthenticationWebFilter) {
                AuthenticationWebFilter webFilter = (AuthenticationWebFilter) f;
                //将自定义的AuthenticationConverter添加到过滤器中
                webFilter.setServerAuthenticationConverter(new XTAuthenticationConverter());
            }
        }
        return chain;

    }

    @Bean
    public ReactiveAuthenticationManager reactiveAuthenticationManager() {
        return new ReactiveAuthenticationManagerAdapter((authentication)->{
            if(authentication instanceof XTAccountAuthentication) {
                XTAccountAuthentication gmAccountAuthentication = (XTAccountAuthentication) authentication;
                if(gmAccountAuthentication.getPrincipal() != null) {
                    authentication.setAuthenticated(true);
                    return authentication;
                } else {
                    return authentication;
                }
            } else {
                return authentication;
            }
        });
    }


}
