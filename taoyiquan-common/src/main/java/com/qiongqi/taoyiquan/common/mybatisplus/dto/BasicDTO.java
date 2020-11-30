package com.qiongqi.taoyiquan.common.mybatisplus.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.qiongqi.taoyiquan.common.validator.group.AddGroup;
import com.qiongqi.taoyiquan.common.validator.group.UpdateGroup;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.io.Serializable;
import java.util.Date;

public abstract class BasicDTO implements Serializable {

    /** id */
    @Null(
            message = "{id.null}",
            groups = {AddGroup.class}
    )
    @NotNull( message = "{id.require}",groups = {UpdateGroup.class})
    private Long id;

    /** 创建时间 */
    @JsonProperty(
            access = Access.READ_ONLY
    )
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss",
            timezone = "GMT+8"
    )
    private Date createTime;

    public BasicDTO() {}

    public Long getId() {
        return this.id;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    @JsonProperty(
            access = Access.READ_ONLY
    )
    public void setCreateTime(final Date createTime) {
        this.createTime = createTime;
    }



}
