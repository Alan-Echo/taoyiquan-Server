package com.qiongqi.taoyiquan.auth.feign.fallback;

import com.qiongqi.taoyiquan.auth.feign.userFeignClient;
import com.qiongqi.taoyiquan.common.response.ResponseData;
import com.qiongqi.taoyiquan.common.response.ResultCode;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @description: 说明
 * @author: ※狗尾巴草
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
