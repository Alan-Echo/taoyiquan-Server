//package com.qingqi.taoyiquan.gateway.filter;
//
//import com.alibaba.fastjson.JSONObject;
////import com.qiongqi.taoyiquan.common.jwt.JwtTokenUtils;
//import com.qiongqi.taoyiquan.common.jwt.JwtTokenUtils;
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.cloud.gateway.filter.GlobalFilter;
//import org.springframework.core.Ordered;
//import org.springframework.core.io.buffer.DataBuffer;
//import org.springframework.http.server.reactive.ServerHttpRequest;
//import org.springframework.http.server.reactive.ServerHttpResponse;
//import org.springframework.stereotype.Component;
//import org.springframework.util.AntPathMatcher;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//
//import java.nio.charset.StandardCharsets;
//import java.util.List;
//
///**
// * @description: 说明
// * @author: ※狗尾巴草
// * @date: 2020-11-26 11:07
// **/
//@Component
//public class AuthGlobalFilter implements GlobalFilter, Ordered {
//    AntPathMatcher antPathMatcher=new AntPathMatcher();
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        ServerHttpRequest request = exchange.getRequest();
//        String path = request.getURI().getPath();
//        if(antPathMatcher.match("/admin/**",path)||antPathMatcher.match("/user/**",path)){
//            System.out.println("拦截了: "+path);
//            List<String> tokenlist = request.getHeaders().get("token");
//            ServerHttpResponse response = exchange.getResponse();
//            //没有token
//            if(tokenlist==null){
//                return out(response);
//            }else {
////                token校验失败
//                if(!JwtTokenUtils.checkJWT(tokenlist.get(0))){
//                    return out(response);
//                }
//            }
//        }
//        return chain.filter(exchange);
//    }
//
//    @Override
//    public int getOrder() {
//        return -1;
//    }
//
//    private Mono<Void> out(ServerHttpResponse response) {
//        JSONObject message = new JSONObject();
//        message.put("success", false);
//        message.put("code", 28004);
//        message.put("data", "鉴权失败");
//        byte[] bits = message.toString().getBytes(StandardCharsets.UTF_8);
//        DataBuffer buffer = response.bufferFactory().wrap(bits);
//        //response.setStatusCode(HttpStatus.UNAUTHORIZED);
//        //指定编码，否则在浏览器中会中文乱码
//        response.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
//        return response.writeWith(Mono.just(buffer));
//    }
//}
