package com.microservices.admin.service;

import com.microservices.common.mybatisplus.server.BaseServiceImpl;
import com.microservices.admin.mapper.XAdminMapper;
import com.microservices.admin.model.dto.XAdminDTO;
import com.microservices.admin.model.entity.XAdminEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Description: 【  Service接口实现类 】
 *
 * 
 * @version : 1.0.0
 * 
 * @date : 2020-11-27 12:05:28
 */
@Service
public class XAdminServiceImpl extends BaseServiceImpl<XAdminMapper, XAdminEntity> implements XAdminService {

    // ==================== 查询 ====================


    @Override
    public XAdminDTO getbyAccount(String account) {
        return baseMapper.getbyAccount(account);
    }

    // ==================== 增、改、删 ====================


    @Override
    public boolean updateLoginTime(String account, Date loginTime) {
        return baseMapper.updateLoginTime(account,loginTime);
    }




}
