package com.microservices.user.service;

import com.microservices.common.mybatisplus.server.BaseServiceImpl;
import com.microservices.user.mapper.XUserMapper;
import com.microservices.user.model.dto.XUserDTO;
import com.microservices.user.model.entity.XUserEntity;
import org.springframework.stereotype.Service;

/**
 * Description: 【  Service接口实现类 】
 *
 * 
 * @version : 1.0.0
 * 
 * @date : 2020-11-28 19:36:52
 */
@Service
public class XUserServiceImpl extends BaseServiceImpl<XUserMapper, XUserEntity> implements XUserService {

    // ==================== 查询 ====================


    @Override
    public XUserDTO getbyAccount(String account) {
        return baseMapper.getbyAccount( account) ;
    }


}
