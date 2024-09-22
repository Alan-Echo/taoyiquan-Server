package com.microservices.gateway.exction;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
* @description: 网关异常通用处理器，只作用在webflux 环境下
* 
* @date: 2020-11-28 16:28
**/
@Slf4j
@Order(-1)
@RequiredArgsConstructor
@Component
public class GlobalExceptionConfiguration implements ErrorWebExceptionHandler {
   private final ObjectMapper objectMapper;

   @Override
   public Mono<Void> handle(ServerWebExchange exchange, Throwable ex) {
       log.error("发生异常", ex);
       ServerHttpResponse response = exchange.getResponse();

       if (response.isCommitted()) {
           return Mono.error(ex);
       }

       // header set
       response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
       if (ex instanceof ResponseStatusException) {
           response.setStatusCode(((ResponseStatusException) ex).getStatus());
       }

       return response
               .writeWith(Mono.fromSupplier(() -> {
                   DataBufferFactory bufferFactory = response.bufferFactory();
                   try {
                       return bufferFactory.wrap(objectMapper.writeValueAsBytes(ex.getMessage()));
                   } catch (JsonProcessingException e) {
//                        log.warn("Error writing response", ex);
                       return bufferFactory.wrap(new byte[0]);
                   }
               }));
   }
}
