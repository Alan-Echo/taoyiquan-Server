package com.qingqi.taoyiquan.gateway.config.handler;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * @description: 说明
 * @author: ※狗尾巴草
 * @date: 2020-11-27 23:13
 **/
public class XTAccountAuthentication extends AbstractAuthenticationToken {

    private static final long serialVersionUID = 1L;
    private Object credentials;
    private String principal;

    public XTAccountAuthentication(Object credentials,String principal,Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.credentials = credentials;
        this.principal = principal;
    }

    @Override
    public Object getCredentials() {
        return this.credentials;
    }

    @Override
    public String getPrincipal() {
        return this.principal;
    }
}
