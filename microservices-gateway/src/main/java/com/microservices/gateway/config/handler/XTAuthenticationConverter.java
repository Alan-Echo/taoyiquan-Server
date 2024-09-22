package com.microservices.gateway.config.handler;

import com.microservices.common.jwt.JwtTokenUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.server.authentication.ServerFormLoginAuthenticationConverter;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 取出token中的权限信息
 * 
 * @date: 2020-11-27 23:12
 **/
public class XTAuthenticationConverter extends ServerFormLoginAuthenticationConverter {
    private static Logger logger = LoggerFactory.getLogger(XTAuthenticationConverter.class);

    @Override
    public Mono<Authentication> convert(ServerWebExchange exchange) {
        logger.info("测试日志收集....................");
        //从token中获取登陆用户信息
        List<String> tokenList = exchange.getRequest().getHeaders().get("token");
        if (tokenList == null) {
            logger.error("用户认证信息为空,返回获取认证信息失败");
            return Mono.empty();
        } else {
            String token = tokenList.get(0);
            List<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
            //获取权限信息
            if (!JwtTokenUtils.checkJWT(token)) {
                logger.error("用户认证信息为空,返回获取认证信息失败");
                return Mono.empty();
            }
            List<String> roles = JwtTokenUtils.getUserRole(token);
            if (roles == null) {
                logger.error("token过期:[{}]", token);
                return Mono.empty();
            }
            roles.forEach(role -> {
                SimpleGrantedAuthority auth = new SimpleGrantedAuthority(role);
                simpleGrantedAuthorities.add(auth);
            });
            //添加用户信息到spring security之中。
            XTAccountAuthentication xinyueAccountAuthentication = new XTAccountAuthentication(null, token, simpleGrantedAuthorities);
            return Mono.just(xinyueAccountAuthentication);
        }
    }
}
