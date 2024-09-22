package com.microservices.auth.feign.fallback;

import com.microservices.auth.feign.userFeignClient;
import com.microservices.common.response.ResponseData;
import com.microservices.common.response.ResultCode;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @description: 说明
 * 
 * @date: 2020-11-29 1:13
 **/
@Component
public class userFeignFallback implements userFeignClient {
    @Override
    public ResponseData getByAccount(String account) {
        return new ResponseData().fail(ResultCode.SERVER_ERROR);
    }

    @Override
    public ResponseData updateLoginTime(String account, Date loginTime) {
        return new ResponseData().fail(ResultCode.SERVER_ERROR);
    }
}
