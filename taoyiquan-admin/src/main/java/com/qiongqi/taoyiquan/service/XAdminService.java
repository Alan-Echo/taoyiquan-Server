package com.qiongqi.taoyiquan.service;


import com.qiongqi.taoyiquan.common.mybatisplus.page.PageData;
import com.qiongqi.taoyiquan.common.mybatisplus.server.BaseService;
import com.qiongqi.taoyiquan.model.dto.XAdminDTO;
import com.qiongqi.taoyiquan.model.entity.XAdminEntity;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Description: 【  Service接口 】
 *
 * @author : ※狗尾巴草
 * @email : "m962464oo@gmail.com"
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
     * @author: ※狗尾巴草
     * @email:  "m962464oo@gmail.com"
     * @date: 2020-11-27 12:05:28
     */
    XAdminDTO getbyAccount(String account);

    // ==================== 增、改、删 ===================


    boolean updateLoginTime(String account, Date loginTime);

    // ==================== 其他 ====================

}
