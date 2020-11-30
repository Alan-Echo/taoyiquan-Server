package com.qiongqi.taoyiquan.model.dto;

import com.qiongqi.taoyiquan.common.mybatisplus.dto.BasicDTO;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


/**
 * Description: 【  DTO 】
 *
 * @author : ※狗尾巴草
 * @version : 1.0.0
 * @email : "m962464oo@gmail.com"
 * @date : 2020-11-27 12:05:28
 */
@Data
public class XAdminDTO extends BasicDTO {

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

    /** 上册登陆时间 */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS", timezone = "GMT+8")
    private Date lastLoginTime;

    /** 修改者ID */
    private Long modifierId;

    /** 账户登录账号 */
    private String account;

    /** 用户名 */
    private String username;

    /** 密码 */
    private String password;


    // ==================== 非持久 ====================



}
