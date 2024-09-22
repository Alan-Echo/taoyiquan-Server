package com.microservices.gateway.config.handler;

import com.alibaba.fastjson.JSONObject;
import com.microservices.common.response.ResponseData;
import com.microservices.common.response.ResultCode;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.ReactiveAuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.server.authorization.AuthorizationContext;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 鉴权
 * 
 * @date: 2020-11-27 21:46
 **/
public class XTReactiveAuthorizationManager implements ReactiveAuthorizationManager<AuthorizationContext>  {

    private List<String> authorities = new ArrayList<>();

    public XTReactiveAuthorizationManager(String authority, String... authorities ) {
        this.authorities.add("ROLE_" + authority);
        if(authorities != null) {
            for(String auth : authorities) {
                this.authorities.add("ROLE_" + auth);
            }
        }
    }

    @Override
    public Mono<AuthorizationDecision> check(Mono<Authentication> authentication, AuthorizationContext authorizationContext) {

        return authentication
                .filter(a -> a.isAuthenticated())
                .flatMapIterable(a -> a.getAuthorities())
                .map(g -> g.getAuthority())
                .any(c -> {
                    //检测权限是否匹配
//                    System.out.println("角色: " + c);
                    if (authorities.contains(c)) {
                        return true;
                    }
                    ResponseData<Object> data = new ResponseData<>().fail(ResultCode.NO_PERMISSION.getCode(),ResultCode.NO_PERMISSION.getMessage());
                    throw new AccessDeniedException(JSONObject.toJSONString(data));
                })
                .map(hasAuthority -> new AuthorizationDecision(hasAuthority))
                .defaultIfEmpty(new AuthorizationDecision(false));
    }
}
