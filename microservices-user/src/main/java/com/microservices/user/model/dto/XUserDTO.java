package com.microservices.user.model.dto;

import com.microservices.common.mybatisplus.dto.BasicDTO;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


/**
 * Description: 【  DTO 】
 *
 * 
 * @version : 1.0.0
 * 
 * @date : 2020-11-28 19:36:52
 */
@Data
public class XUserDTO extends BasicDTO {

    // ==================== 字段名 ====================

    /** 创建时间 */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS", timezone = "GMT+8")
    private Date createTime;

    /** 创建者ID */
    private Long creatorId;

    /** 修改时间 */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS", timezone = "GMT+8")
    private Date modifyTime;

    /** 修改者ID */
    private Long modifierId;

    /** 账户登录账号 */
    private String account;

    /** 用户名 */
    private String username;

    /** 密码 */
    private String password;

    /** 帐号是否已经过期,1:可用,0不可用 */
    private Integer accountNonExpired;

    /** 帐号是否已被锁定,1:可用,0不可用 */
    private Integer accountNonLocked;

    /** 用户凭证是否已经过期,1:可用,0不可用 */
    private Integer credentialsNonExpired;

    /** 帐号是否禁用,1:可用,0不可用 */
    private Integer enabled;

    /** 上次登陆时间 */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS", timezone = "GMT+8")
    private Date lastLoginTime;

    // ==================== 非持久 ====================



}
