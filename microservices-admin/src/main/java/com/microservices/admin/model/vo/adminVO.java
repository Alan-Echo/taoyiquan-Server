package com.microservices.admin.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.microservices.common.mybatisplus.vo.BasicVO;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @description: 说明
 * 
 * @date: 2020-11-30 23:32
 **/
public class adminVO extends BasicVO {


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
    private String userName;




}
