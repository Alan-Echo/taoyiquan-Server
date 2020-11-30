package com.qiongqi.taoyiquan.auth.feign;

import com.qiongqi.taoyiquan.auth.feign.fallback.adminFeignFallBack;
import com.qiongqi.taoyiquan.common.response.ResponseData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

/**
 * @description: admin服务调用
 *  * 声明需要调用的微服务名称
 *  *  @FeignClient  //Feign默认集成了ribbon的轮询策略
 *  *      * name : 服务提供者的名称
 * @author: ※狗尾巴草
 * @date: 2020-11-27 11:20
 **/
@Component
@FeignClient(name="taoyiquan-admin",contextId = "admin",fallback = adminFeignFallBack.class)
public interface adminFeignClient {

    @GetMapping("/api-admin/v1/admin/entity/getByAccount")
    ResponseData getByAccount(@RequestParam("account") String account);

    @GetMapping("/api-admin/v1/admin/entity/updateLoginTime")
    ResponseData updateLoginTime(@RequestParam("account") String account, @RequestParam("loginTime") Date loginTime);

}
