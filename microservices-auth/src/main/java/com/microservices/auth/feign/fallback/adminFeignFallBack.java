package com.microservices.auth.feign.fallback;

import com.microservices.auth.feign.adminFeignClient;
import com.microservices.common.response.ResponseData;
import com.microservices.common.response.ResultCode;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @description: adminFeignClient fallback
 * 
 * @date: 2020-11-29 0:14
 **/
@Component
public class adminFeignFallBack implements adminFeignClient {
    @Override
    public ResponseData getByAccount(String account) {
        return new ResponseData().fail(ResultCode.SERVER_ERROR);
    }

    @Override
    public ResponseData updateLoginTime(String account, Date loginTime) {
        return new ResponseData().fail(ResultCode.SERVER_ERROR);
    }
}
