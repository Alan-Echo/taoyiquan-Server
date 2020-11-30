package com.qiongqi.taoyiquan.auth.handler;

import com.alibaba.fastjson.JSON;
import com.qiongqi.taoyiquan.common.response.ResponseData;
import com.qiongqi.taoyiquan.common.response.ResultCode;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description: 登录失败处理逻辑
 * @author: ※狗尾巴草
 * @date: 2020-11-13 14:22
 **/
@Component
public class CustomizeAuthenticationFailureHandler implements AuthenticationFailureHandler {


    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        //返回json数据
        ResponseData<Object> data = null;
        if (e instanceof AccountExpiredException) {
            //账号过期
            data = new ResponseData<>().fail(ResultCode.USER_ACCOUNT_EXPIRED.getCode(),ResultCode.USER_ACCOUNT_EXPIRED.getMessage());
        } else if (e instanceof BadCredentialsException) {
            //密码错误
            data = new ResponseData<>().fail(ResultCode.USER_CREDENTIALS_ERROR.getCode(),ResultCode.USER_CREDENTIALS_ERROR.getMessage());
        } else if (e instanceof CredentialsExpiredException) {
            //密码过期
            data = new ResponseData<>().fail(ResultCode.USER_CREDENTIALS_EXPIRED.getCode(),ResultCode.USER_CREDENTIALS_EXPIRED.getMessage());
        } else if (e instanceof DisabledException) {
            //账号不可用
            data = new ResponseData<>().fail(ResultCode.USER_ACCOUNT_DISABLE.getCode(),ResultCode.USER_ACCOUNT_DISABLE.getMessage());
        } else if (e instanceof LockedException) {
            //账号锁定
            data = new ResponseData<>().fail(ResultCode.USER_ACCOUNT_LOCKED.getCode(),ResultCode.USER_ACCOUNT_LOCKED.getMessage());
        } else if (e instanceof InternalAuthenticationServiceException) {
            //用户不存在
            data = new ResponseData<>().fail(ResultCode.USER_ACCOUNT_NOT_EXIST.getCode(),ResultCode.USER_ACCOUNT_NOT_EXIST.getMessage());
        }else{
            //其他错误
            data = new ResponseData<>().fail(ResultCode.COMMON_FAIL.getCode(),ResultCode.COMMON_FAIL.getMessage());
        }
        //处理编码方式，防止中文乱码的情况
        httpServletResponse.setContentType("text/json;charset=utf-8");
        //塞到HttpServletResponse中返回给前台
        httpServletResponse.getWriter().write(JSON.toJSONString(data));
    }
}

