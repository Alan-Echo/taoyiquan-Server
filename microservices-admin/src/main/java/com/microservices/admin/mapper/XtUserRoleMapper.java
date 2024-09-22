package com.microservices.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.microservices.admin.model.dto.XtRoleDTO;
import com.microservices.admin.model.entity.XtUserRoleEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Description: 【  数据库操作Mapper 】
 *
 * 
 * @version : 1.0.0
 * 
 * @date : 2020-11-27 12:05:27
 */
@Mapper
public interface XtUserRoleMapper extends BaseMapper<XtUserRoleEntity> {

    // ==================== 查询 ====================



    @Select("select r.* from x_role r left join x_user_role ur on ur.roleId=r.id where ur.userId = #{userId}")
    List<XtRoleDTO> getByUserId(@Param("userId") Long userId);


    // ==================== 增、改、删  ===================


    // ==================== 其他 ====================

}
