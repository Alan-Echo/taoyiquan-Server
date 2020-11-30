package com.qiongqi.taoyiquan.model.dto;

import com.qiongqi.taoyiquan.common.mybatisplus.dto.BasicDTO;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


/**
 * Description: 【  DTO 】
 *
 * @author : ※狗尾巴草
 * @version : 1.0.0
 * @email : "m962464oo@gmail.com"
 * @date : 2020-11-27 12:05:27
 */
@Data
public class XtRoleDTO extends BasicDTO {

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

    /** 角色名 */
    private String roleName;

    /** 角色代码 */
    private String roleCode;


    // ==================== 非持久 ====================


}
