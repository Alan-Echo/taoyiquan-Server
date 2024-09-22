package com.microservices.admin.model.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.microservices.common.mybatisplus.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Description: 【  实体 】
 *
 * 
 * @version : 1.0.0
 * 
 * @date : 2020-11-27 12:05:27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("X_ROLE")
public class XtRoleEntity extends BaseEntity<XtRoleEntity> {

    // ==================== 字段名 ====================

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS", timezone = "GMT+8")
    @TableField(value = "createTime")
    private Date createTime;

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
     * 角色名
     */
    @TableField(value = "roleName")
    private String roleName;

    /**
     * 角色代码
     */
    @TableField(value = "roleCode")
    private String roleCode;

    // ==================== 非持久 ====================


}
