package com.microservices.admin.service;

import com.microservices.common.mybatisplus.server.BaseService;
import com.microservices.admin.model.dto.XtRoleDTO;
import com.microservices.admin.model.entity.XtUserRoleEntity;

import java.util.List;

/**
 * Description: 【  Service接口 】
 *
 * 
 * @version : 1.0.0
 * 
 * @date : 2020-11-27 12:05:27
 */
public interface XtUserRoleService extends BaseService<XtUserRoleEntity> {

    // ==================== 查询 ====================

    List<XtRoleDTO> getByUserId(Long userId);


}
