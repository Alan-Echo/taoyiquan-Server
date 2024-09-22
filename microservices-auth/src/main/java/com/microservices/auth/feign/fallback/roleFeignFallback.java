package com.microservices.auth.feign.fallback;

import com.microservices.auth.feign.roleFeignClient;
import com.microservices.common.response.ResponseData;
import com.microservices.common.response.ResultCode;
import org.springframework.stereotype.Component;

/**
 * @description: 说明
 * 
 * @date: 2020-11-29 1:11
 **/
@Component
public class roleFeignFallback implements roleFeignClient {
    @Override
    public ResponseData getByUserId(String userId) {
        return new ResponseData().fail(ResultCode.SERVER_ERROR);
    }
}
