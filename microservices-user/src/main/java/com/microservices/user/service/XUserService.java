package com.microservices.user.service;

import com.microservices.common.mybatisplus.server.BaseService;
import com.microservices.user.model.dto.XUserDTO;
import com.microservices.user.model.entity.XUserEntity;

/**
 * Description: 【  Service接口 】
 *
 * 
 * @version : 1.0.0
 * 
 * @date : 2020-11-28 19:36:52
 */
public interface XUserService extends BaseService<XUserEntity> {

    // ==================== 查询 ====================


    XUserDTO getbyAccount(String account);



}
