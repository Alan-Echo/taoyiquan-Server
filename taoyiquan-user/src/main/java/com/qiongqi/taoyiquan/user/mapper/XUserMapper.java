package com.qiongqi.taoyiquan.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qiongqi.taoyiquan.user.model.dto.XUserDTO;
import com.qiongqi.taoyiquan.user.model.entity.XUserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Description: 【  数据库操作Mapper 】
 *
 * @author : ※狗尾巴草
 * @version : 1.0.0
 * @email : "m962464oo@gmail.com"
 * @date : 2020-11-28 19:36:52
 */
@Mapper
public interface XUserMapper extends BaseMapper<XUserEntity> {

    // ==================== 查询 ====================



    @Select("select * from X_USER where account = #{account}")
    XUserDTO getbyAccount(@Param("account") String account);




}
