package com.api.tiktokapi.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @TableName live_warrant
 */
@TableName(value = "live_warrant")
@Data
public class LiveWarrant implements Serializable {
    /**
     * 主键
     */
    @TableId
    private Long id;

    /**
     * 直播间id
     */
    private String liveId;

    /**
     * 设备id
     */
    private String device;

    /**
     * 到期时间
     */
    private Date expirationDate;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 备注
     */
    private String remark;

    /**
     * 授权码
     */
    private String warrant;

    /**
     * 状态
     */
    private Long status;

    /**
     * 校验码
     */
    @TableField(exist = false)
    private String code;

    @Override
    public String toString() {
        return "LiveWarrant{" +
                "id=" + id +
                ", liveId='" + liveId + '\'' +
                ", device='" + device + '\'' +
                ", expirationDate=" + expirationDate +
                ", createTime=" + createTime +
                ", remark='" + remark + '\'' +
                ", warrant='" + warrant + '\'' +
                ", status=" + status +
                ", code='" + code + '\'' +
                ", time=" + time +
                ", random='" + random + '\'' +
                '}';
    }

    /**
     * 时间戳
     */
    @TableField(exist = false)
    Long time;

    /*
     *  随机码
     */
    @TableField(exist = false)
    String random;
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        LiveWarrant other = (LiveWarrant) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getLiveId() == null ? other.getLiveId() == null : this.getLiveId().equals(other.getLiveId()))
                && (this.getDevice() == null ? other.getDevice() == null : this.getDevice().equals(other.getDevice()))
                && (this.getExpirationDate() == null ? other.getExpirationDate() == null : this.getExpirationDate().equals(other.getExpirationDate()))
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
                && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
                && (this.getWarrant() == null ? other.getWarrant() == null : this.getWarrant().equals(other.getWarrant()))
                && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getLiveId() == null) ? 0 : getLiveId().hashCode());
        result = prime * result + ((getDevice() == null) ? 0 : getDevice().hashCode());
        result = prime * result + ((getExpirationDate() == null) ? 0 : getExpirationDate().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getWarrant() == null) ? 0 : getWarrant().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }

}