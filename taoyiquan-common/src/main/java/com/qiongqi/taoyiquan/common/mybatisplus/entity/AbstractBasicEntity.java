package com.qiongqi.taoyiquan.common.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class AbstractBasicEntity<T extends Model<T>> extends Model<T> {
    @TableId
    @TableField("ID")
    private Long id;

    @DateTimeFormat(
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss",
            timezone = "GMT+8"
    )
    @TableField(
            value = "createTime",
            fill = FieldFill.INSERT
    )
    private Date createTime;


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

    @TableField(
            value = "modifyTime",
            fill = FieldFill.INSERT_UPDATE
    )
    private Date modifyTime;

    public AbstractBasicEntity() {
    }

    public Long getId() {
        return this.id;
    }

    public Date getCreateTime() {
        return this.createTime;
    }


    public void setId(final Long id) {
        this.id = id;
    }

    public void setCreateTime(final Date createTime) {
        this.createTime = createTime;
    }

    public Long getCreatorId() {
        return CreatorId;
    }

    public void setCreatorId(Long creatorId) {
        CreatorId = creatorId;
    }

    public Long getModifierId() {
        return ModifierId;
    }

    public void setModifierId(Long modifierId) {
        ModifierId = modifierId;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    public String toString() {
        return "AbstractBasicEntity{" +
                "id=" + id +
                ", createTime=" + createTime +
                ", CreatorId=" + CreatorId +
                ", ModifierId=" + ModifierId +
                ", modifyTime=" + modifyTime +
                '}';
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof AbstractBasicEntity)) {
            return false;
        } else {
            AbstractBasicEntity<?> other = (AbstractBasicEntity)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label47: {
                    Object this$creatorId = this.getCreatorId();
                    Object other$creatorId = other.getCreatorId();
                    if (this$creatorId == null) {
                        if (other$creatorId == null) {
                            break label47;
                        }
                    } else if (this$creatorId.equals(other$creatorId)) {
                        break label47;
                    }

                    return false;
                }

                Object this$modifierId = this.getModifierId();
                Object other$modifierId = other.getModifierId();
                if (this$modifierId == null) {
                    if (other$modifierId != null) {
                        return false;
                    }
                } else if (!this$modifierId.equals(other$modifierId)) {
                    return false;
                }

                Object this$modifyTime = this.getModifyTime();
                Object other$modifyTime = other.getModifyTime();
                if (this$modifyTime == null) {
                    if (other$modifyTime != null) {
                        return false;
                    }
                } else if (!this$modifyTime.equals(other$modifyTime)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof AbstractBasicEntity;
    }

    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        Object $creatorId = this.getCreatorId();
         result = result * 59 + ($creatorId == null ? 43 : $creatorId.hashCode());
        Object $modifierId = this.getModifierId();
        result = result * 59 + ($modifierId == null ? 43 : $modifierId.hashCode());
        Object $modifyTime = this.getModifyTime();
        result = result * 59 + ($modifyTime == null ? 43 : $modifyTime.hashCode());
        return result;
    }

}

