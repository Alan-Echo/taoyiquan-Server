package com.qiongqi.taoyiquan.auth.server;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qiongqi.taoyiquan.auth.feign.adminFeignClient;
import com.qiongqi.taoyiquan.auth.feign.roleFeignClient;
import com.qiongqi.taoyiquan.auth.feign.userFeignClient;
import com.qiongqi.taoyiquan.common.mybatisplus.entity.AuthenticationUser;
import com.qiongqi.taoyiquan.common.response.ResponseData;
import com.qiongqi.taoyiquan.common.response.ResultCode;
import com.qiongqi.taoyiquan.common.utils.MapBeanUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.*;

/**
 * @description: 登录认证授权
 * @author: ※狗尾巴草
 * @date: 2020-11-13 10:00
 **/
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private adminFeignClient adminFeignClient;

    @Autowired
    private roleFeignClient roleFeignClient;

    @Autowired
    private userFeignClient userFeignClient;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //需要构造出 org.springframework.security.core.userdetails.User 对象并返回
        
        //
        if(!StringUtils.isNotBlank(username)){
            throw new RuntimeException("用户不能为空");
        }
        ResponseData Account =null;
                String[] name_list = username.split("_");
        if("user".equals(name_list[0])){
//            普通用户登录
            Account = userFeignClient.getByAccount(name_list[1]);

        }else if("admin".equals(name_list[0])){
//            管理员登录
            Account = adminFeignClient.getByAccount(name_list[1]);
        }
//        LinkedHashMap data = (LinkedHashMap) Account.getData();
        // admin微服务异常
        if(Account.getStatus()!= ResultCode.SUCCESS.getCode()){
            throw new RuntimeException("用户不存在");
        }
        JSONObject data = ((JSONObject) JSONObject.toJSON(Account)).getJSONObject("data");
        List<GrantedAuthority> grantedAuthorities  = new ArrayList<>();
        //获取该用户所拥有的角色
        ResponseData roleData = roleFeignClient.getByUserId(data.get("id").toString());
        if(roleData.getData()==null){
            throw new RuntimeException("用户不存在");
        }
        JSONObject roleJson =(JSONObject) JSONObject.toJSON(roleData);

        Set<GrantedAuthority> authorities =null;
        //角色和权限共用GrantedAuthority接口，唯一的不同角色就是多了个前缀"ROLE_"

//        // 声明用户角色
        roleJson.getJSONArray("data").forEach(role ->{
            //基于角色控制
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_"+((JSONObject)role).get("roleCode")));
        });

        AuthenticationUser authenticationUser = new AuthenticationUser(
                data.getLong("id"),grantedAuthorities,
                data.getString("password"),data.getString("account"),true,
                true,true,
                true
        );
//        User user = new User(data.get("account").toString(), data.get("password").toString(), true, true, true, true, grantedAuthorities);
        return authenticationUser;
    }

}

