package com.microservices.admin.service;

import com.microservices.common.mybatisplus.server.BaseServiceImpl;
import com.microservices.admin.mapper.XtUserRoleMapper;
import com.microservices.admin.model.dto.XtRoleDTO;
import com.microservices.admin.model.entity.XtUserRoleEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description: 【  Service接口实现类 】
 *
 * 
 * @version : 1.0.0
 * 
 * @date : 2020-11-27 12:05:27
 */
@Service
public class XtUserRoleServiceImpl extends BaseServiceImpl<XtUserRoleMapper, XtUserRoleEntity> implements XtUserRoleService {

    // ==================== 查询 ====================

    @Override
    public List<XtRoleDTO> getByUserId(Long userId) {
        return baseMapper.getByUserId(userId);
    }

    // ==================== 增、改、删 ====================


}
