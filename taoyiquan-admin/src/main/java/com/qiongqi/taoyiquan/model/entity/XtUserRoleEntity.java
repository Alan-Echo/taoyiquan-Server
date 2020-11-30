package com.qiongqi.taoyiquan.model.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.qiongqi.taoyiquan.common.mybatisplus.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Description: 【  实体 】
 *
 * @author : ※狗尾巴草
 * @version : 1.0.0
 * @email : "m962464oo@gmail.com"
 * @date : 2020-11-27 12:05:27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("XT_USER_ROLE")
public class XtUserRoleEntity extends BaseEntity<XtUserRoleEntity> {

    // ==================== 字段名 ====================

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS", timezone = "GMT+8")
    @TableField(value = "createTime")
    private Date createtime;

    /**
     * 创建者ID
     */
    @TableField(value = "creatorId")
    private Long creatorId;

    /**
     * 修改时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS", timezone = "GMT+8")
    @TableField(value = "modifyTime")
    private Date modifyTime;

    /**
     * 修改者ID
     */
    @TableField(value = "modifierId")
    private Long modifierId;

    /**
     * COMMON_USER用户表的ID
     */
    @TableField(value = "userId")
    private Long userId;

    /**
     * 角色表ID
     */
    @TableField(value = "roleId")
    private Long roleId;

    // ==================== 非持久 ====================

}
