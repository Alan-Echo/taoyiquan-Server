package com.qiongqi.taoyiquan.auth.feign;

import com.qiongqi.taoyiquan.auth.feign.fallback.roleFeignFallback;
import com.qiongqi.taoyiquan.common.response.ResponseData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @description: admin服务调用-获取用户角色
 * @author: ※狗尾巴草
 * @date: 2020-11-27 12:50
 **/
@FeignClient(name="taoyiquan-admin",contextId = "role",fallback = roleFeignFallback.class)
public interface roleFeignClient {

    @GetMapping("/api-admin/v1/admin/user_role/getByUserId")
    ResponseData getByUserId(@RequestParam("userId") String userId);


}
