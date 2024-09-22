package com.microservices.admin.model.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.microservices.common.mybatisplus.dto.BasicDTO;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Description: 【  DTO 】
 *
 * 
 * @version : 1.0.0
 * 
 * @date : 2020-11-27 12:05:27
 */
@Data
public class XtUserRoleDTO extends BasicDTO {

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

    /** COMMON_USER用户表的ID */
    private Long userId;

    /** 角色表ID */
    private Long roleId;

    // ==================== N非持久 ====================



}
