package com.microservices.auth.feign;

import com.microservices.auth.feign.fallback.userFeignFallback;
import com.microservices.common.response.ResponseData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

/**
 * @description: 说明
 * 
 * @date: 2020-11-28 19:22
 **/
@FeignClient(name="microservices-user",contextId = "user",fallback = userFeignFallback.class)
public interface userFeignClient {

    @GetMapping("/api-user/v1/api/entity/getByAccount")
    ResponseData getByAccount(@RequestParam("account") String account);

    @GetMapping("/api-user/v1/api/entity/updateLoginTime")
    ResponseData updateLoginTime(@RequestParam("account") String account, @RequestParam("loginTime") Date loginTime);

}
