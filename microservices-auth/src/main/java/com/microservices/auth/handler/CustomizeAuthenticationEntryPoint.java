package com.microservices.auth.handler;

import com.alibaba.fastjson.JSON;
import com.microservices.common.response.ResponseData;
import com.microservices.common.response.ResultCode;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @description: 匿名用户访问无权限资源时的异常
 * 
 * @date: 2020-11-13 14:15
 **/
@Component
public class CustomizeAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        ResponseData<Object> data = new ResponseData<>().fail(ResultCode.NO_PERMISSION.getCode(),ResultCode.NO_PERMISSION.getMessage());
        httpServletResponse.setContentType("text/json;charset=utf-8");
        httpServletResponse.getWriter().write(JSON.toJSONString(data));
    }

}

