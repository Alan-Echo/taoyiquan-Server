package com.microservices.admin.service;


import com.microservices.common.mybatisplus.server.BaseService;
import com.microservices.admin.model.dto.XAdminDTO;
import com.microservices.admin.model.entity.XAdminEntity;

import java.util.Date;

/**
 * Description: 【  Service接口 】
 *
 * 
 * 
 * @date : 2020-11-27 12:05:28
 * @version : 1.0.0
 */
public interface XAdminService extends BaseService<XAdminEntity> {

    // ==================== 查询 ====================


    /**
     * Description:【 通过登录账户获取单条数据 】
     *
     * @param account
     * @return
     * 
     * @date: 2020-11-27 12:05:28
     */
    XAdminDTO getbyAccount(String account);

    // ==================== 增、改、删 ===================


    boolean updateLoginTime(String account, Date loginTime);

    // ==================== 其他 ====================

}
