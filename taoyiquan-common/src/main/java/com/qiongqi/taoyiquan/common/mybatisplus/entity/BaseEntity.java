package com.qiongqi.taoyiquan.common.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;

public class BaseEntity<T extends Model<T>> extends AbstractBasicEntity<T>  {

    @DateTimeFormat(
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss",
            timezone = "GMT+8"
    )
    @TableField(
            value = "modifyTime",
            fill = FieldFill.INSERT_UPDATE
    )
    private Date modifyTime;

    @TableField(
            value = "creatorId",
            fill = FieldFill.INSERT
    )
    private Long CreatorId;

    @TableField(
            value = "modifierId",
            fill = FieldFill.INSERT_UPDATE
    )
    private Long ModifierId;


    public BaseEntity() {

    }


    public Date getModifyTime() {
        return this.modifyTime;
    }
    public void setModifyTime(final Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Long getCreatorId() {
        return CreatorId;
    }

    public void setCreatorId(Long createId) {
        CreatorId = createId;
    }

    public Long getModifierId() {
        return ModifierId;
    }

    public void setModifierId(Long modifierId) {
        ModifierId = modifierId;
    }



}
