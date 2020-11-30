package com.qiongqi.taoyiquan.user.service;

import com.qiongqi.taoyiquan.common.mybatisplus.page.PageData;
import com.qiongqi.taoyiquan.common.mybatisplus.server.BaseService;
import com.qiongqi.taoyiquan.user.model.dto.XUserDTO;
import com.qiongqi.taoyiquan.user.model.entity.XUserEntity;

import java.util.List;
import java.util.Map;

/**
 * Description: 【  Service接口 】
 *
 * @author : ※狗尾巴草
 * @version : 1.0.0
 * @email : "m962464oo@gmail.com"
 * @date : 2020-11-28 19:36:52
 */
public interface XUserService extends BaseService<XUserEntity> {

    // ==================== 查询 ====================


    XUserDTO getbyAccount(String account);



}
