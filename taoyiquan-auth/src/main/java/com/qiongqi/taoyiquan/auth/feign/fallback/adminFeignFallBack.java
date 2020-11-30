package com.qiongqi.taoyiquan.auth.feign.fallback;

import com.qiongqi.taoyiquan.auth.feign.adminFeignClient;
import com.qiongqi.taoyiquan.common.response.ResponseData;
import com.qiongqi.taoyiquan.common.response.ResultCode;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @description: adminFeignClient fallback
 * @author: ※狗尾巴草
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
