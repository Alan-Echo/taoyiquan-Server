package com.qiongqi.taoyiquan.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qiongqi.taoyiquan.common.mybatisplus.page.PageData;
import com.qiongqi.taoyiquan.common.mybatisplus.page.PageUtils;
import com.qiongqi.taoyiquan.common.mybatisplus.server.BaseServiceImpl;
import com.qiongqi.taoyiquan.common.utils.ConvertUtils;
import com.qiongqi.taoyiquan.mapper.XtUserRoleMapper;
import com.qiongqi.taoyiquan.model.dto.XtRoleDTO;
import com.qiongqi.taoyiquan.model.dto.XtUserRoleDTO;
import com.qiongqi.taoyiquan.model.entity.XtUserRoleEntity;
import org.apache.commons.collections4.MapUtils;
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
