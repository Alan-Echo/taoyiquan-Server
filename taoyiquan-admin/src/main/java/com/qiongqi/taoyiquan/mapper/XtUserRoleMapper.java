package com.qiongqi.taoyiquan.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qiongqi.taoyiquan.model.dto.XtRoleDTO;
import com.qiongqi.taoyiquan.model.dto.XtUserRoleDTO;
import com.qiongqi.taoyiquan.model.entity.XtUserRoleEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Description: 【  数据库操作Mapper 】
 *
 * @author : ※狗尾巴草
 * @version : 1.0.0
 * @email : "m962464oo@gmail.com"
 * @date : 2020-11-27 12:05:27
 */
@Mapper
public interface XtUserRoleMapper extends BaseMapper<XtUserRoleEntity> {

    // ==================== 查询 ====================



    @Select("select r.* from xt_role r left join xt_user_role ur on ur.roleId=r.id where ur.userId = #{userId}")
    List<XtRoleDTO> getByUserId(@Param("userId") Long userId);


    // ==================== 增、改、删  ===================


    // ==================== 其他 ====================

}
