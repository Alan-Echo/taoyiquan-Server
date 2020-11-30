package com.qiongqi.taoyiquan.user.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qiongqi.taoyiquan.common.mybatisplus.page.PageData;
import com.qiongqi.taoyiquan.common.mybatisplus.page.PageUtils;
import com.qiongqi.taoyiquan.common.mybatisplus.server.BaseServiceImpl;
import com.qiongqi.taoyiquan.common.utils.ConvertUtils;
import com.qiongqi.taoyiquan.user.mapper.XUserMapper;
import com.qiongqi.taoyiquan.user.model.dto.XUserDTO;
import com.qiongqi.taoyiquan.user.model.entity.XUserEntity;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Description: 【  Service接口实现类 】
 *
 * @author : ※狗尾巴草
 * @version : 1.0.0
 * @email : "m962464oo@gmail.com"
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
