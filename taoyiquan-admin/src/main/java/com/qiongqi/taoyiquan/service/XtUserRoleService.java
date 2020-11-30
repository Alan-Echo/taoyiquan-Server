package com.qiongqi.taoyiquan.service;

import com.qiongqi.taoyiquan.common.mybatisplus.page.PageData;
import com.qiongqi.taoyiquan.common.mybatisplus.server.BaseService;
import com.qiongqi.taoyiquan.model.dto.XtRoleDTO;
import com.qiongqi.taoyiquan.model.dto.XtUserRoleDTO;
import com.qiongqi.taoyiquan.model.entity.XtUserRoleEntity;

import java.util.List;
import java.util.Map;

/**
 * Description: 【  Service接口 】
 *
 * @author : ※狗尾巴草
 * @version : 1.0.0
 * @email : "m962464oo@gmail.com"
 * @date : 2020-11-27 12:05:27
 */
public interface XtUserRoleService extends BaseService<XtUserRoleEntity> {

    // ==================== 查询 ====================

    List<XtRoleDTO> getByUserId(Long userId);


}
