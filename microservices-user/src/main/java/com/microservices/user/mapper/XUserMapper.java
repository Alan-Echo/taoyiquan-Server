package com.microservices.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.microservices.user.model.dto.XUserDTO;
import com.microservices.user.model.entity.XUserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Description: 【  数据库操作Mapper 】
 *
 * 
 * @version : 1.0.0
 * 
 * @date : 2020-11-28 19:36:52
 */
@Mapper
public interface XUserMapper extends BaseMapper<XUserEntity> {

    // ==================== 查询 ====================



    @Select("select * from X_USER where account = #{account}")
    XUserDTO getbyAccount(@Param("account") String account);




}
