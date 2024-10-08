package com.microservices.gateway.config.handler;


import com.alibaba.fastjson.JSONObject;
import com.microservices.common.response.ResponseData;
import com.microservices.common.response.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.server.ServerAuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @description: 匿名用户访问无权限资源时的异常
 * 
 * @date: 2020-11-13 14:15
 **/
@Slf4j
@Component
public class CustomizeAuthenticationEntryPoint implements ServerAuthenticationEntryPoint {


    @Override
    public Mono<Void> commence(ServerWebExchange exchange, AuthenticationException e) {
//        System.out.println("无权限访问");
        log.error("无权限访问");
        ResponseData<Object> data = new ResponseData<>().fail(ResultCode.NO_PERMISSION.getCode(),ResultCode.NO_PERMISSION.getMessage());
//        抛出异常
        return Mono.error(new  AccessDeniedException(JSONObject.toJSONString(data)));
    }



}

