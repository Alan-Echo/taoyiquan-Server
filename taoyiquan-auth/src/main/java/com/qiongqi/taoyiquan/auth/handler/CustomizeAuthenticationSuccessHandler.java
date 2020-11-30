package com.qiongqi.taoyiquan.auth.handler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qiongqi.taoyiquan.auth.feign.adminFeignClient;
import com.qiongqi.taoyiquan.common.jwt.JwtTokenUtils;
import com.qiongqi.taoyiquan.common.mybatisplus.entity.AuthenticationUser;
import com.qiongqi.taoyiquan.common.utils.ConvertUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * @description: 登录成功处理器
 * @author: ※狗尾巴草
 * @date: 2020-11-13 14:19
 **/
@Component
public class CustomizeAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private adminFeignClient adminFeignClient;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        //更新用户表上次登录时间、更新人、更新时间等字段
        AuthenticationUser userDetails = (AuthenticationUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        adminFeignClient.updateLoginTime(userDetails.getUsername(),new Date());

//        SysUserEntity sysUser = sysUserService.selectByName(userDetails.getUsername());
//        sysUser.setLast_login_time(new Date());
//        sysUser.setUpdate_time(new Date());
//        sysUser.setUpdate_user(sysUser.getId());
//        sysUserService.updateById(sysUser);

        //此处还可以进行一些处理，比如登录成功之后可能需要返回给前台当前用户有哪些菜单权限，
        //进而前台动态的控制菜单的显示等，具体根据自己的业务需求进行扩展

        //  获取用户权限
        Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
        List<String> list = new ArrayList<>();
        for (GrantedAuthority authority : authorities){
            list.add(authority.getAuthority());
        }
        //将权限放入token中
        String token = JwtTokenUtils.createToken(userDetails.getUsername(), list);
        JSONObject object = new JSONObject();
        object.put("token",token);
        object.put("account",userDetails.getUsername());
        object.put("id",userDetails.getId());

        //处理编码方式，防止中文乱码的情况
        httpServletResponse.setContentType("text/json;charset=utf-8");
        //塞到HttpServletResponse中返回给前台
        httpServletResponse.getWriter().write(JSON.toJSONString(object));
    }
}

