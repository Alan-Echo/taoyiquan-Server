package com.qiongqi.taoyiquan.user.model.entity;

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
 * @date : 2020-11-28 19:36:52
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("X_USER")
public class XUserEntity extends BaseEntity<XUserEntity> {

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
     * 账户登录账号
     */
    @TableField(value = "account")
    private String account;

    /**
     * 用户名
     */
    @TableField(value = "userName")
    private String username;

    /**
     * 密码
     */
    @TableField(value = "password")
    private String password;

    /**
     * 帐号是否已经过期,1:可用,0不可用
     */
    @TableField(value = "accountNonExpired")
    private Integer accountNonExpired;

    /**
     * 帐号是否已被锁定,1:可用,0不可用
     */
    @TableField(value = "accountNonLocked")
    private Integer accountNonLocked;

    /**
     * 用户凭证是否已经过期,1:可用,0不可用
     */
    @TableField(value = "credentialsNonExpired")
    private Integer credentialsNonExpired;

    /**
     * 帐号是否禁用,1:可用,0不可用
     */
    @TableField(value = "enabled")
    private Integer enabled;

    /**
     * 上次登陆时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS", timezone = "GMT+8")
    @TableField(value = "lastLoginTime")
    private Date lastLoginTime;

    // ==================== 非持久 ====================


}
