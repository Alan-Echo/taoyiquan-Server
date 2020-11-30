package com.qiongqi.taoyiquan.auth.feign.fallback;

import com.qiongqi.taoyiquan.auth.feign.roleFeignClient;
import com.qiongqi.taoyiquan.common.response.ResponseData;
import com.qiongqi.taoyiquan.common.response.ResultCode;
import org.springframework.stereotype.Component;

/**
 * @description: 说明
 * @author: ※狗尾巴草
 * @date: 2020-11-29 1:11
 **/
@Component
public class roleFeignFallback implements roleFeignClient {
    @Override
    public ResponseData getByUserId(String userId) {
        return new ResponseData().fail(ResultCode.SERVER_ERROR);
    }
}
