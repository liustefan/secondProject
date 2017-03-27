/*
 * SmsSendDetail.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-11-28 Created
 */
package com.bithealth.msgCenterCore.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.bithealth.sdk.core.generic.GenericModel;

import java.util.Date;

/**
 * [3.0]短信发送明细
 * 
 * @author ${user}
 * @version 1.0 2016-11-28
 */
public class SmsSendDetail extends GenericModel {

    /**
     * 短信发送明细ID
     */
    private Integer SSDetailID;
    /**
     * 短信发送ID
     */
    private Integer SSendID;
    /**
     * 会员GUID
     */
    private String memberID;
    /**
     * 接收号码
     */
    private String recvNumber;
    /**
     * 发送时间
     */
    @JSONField (format="yyyy-MM-dd HH:mm:ss")  
    private Date sendTime;
    /**
     * 发送状态：1-待发送，2-已发送(至网关)，3-发送成功，4-发送失败
     */
    private Byte sendStatus;
    /**
     * 接收时间
     */
    private Date recvTime;
    /**
     * 发送失败原因
     */
    private String failReason;
    /**
     * 失败次数
     */
    private Integer failCount;
    /**
     * 创建者ID，0-系统
     */
    private Integer createID;
    /**
     * 创建时间
     */
    @JSONField (format="yyyy-MM-dd HH:mm:ss")  
    private Date createTime;
    /**
     * 更新者ID，0-系统
     */
    private Integer updateID;
    /**
     * 更新时间
     */
    @JSONField (format="yyyy-MM-dd HH:mm:ss")  
    private Date updateTime;

    
    //额外增加的参数
    /**
     * 组织ID
     */
    private Integer orgID;
    /**
     * 短信类型：1-会员注册，2-忘记密码，3-邀请短信
     */
    private Byte smsType;
    /**
     * 优先级：1-紧急，2-较高，3-普通，4-较低，5-最低
     */
    private Byte priority;
    /**
     * 发送内容类别：1-文本，2-语音
     */
    private Byte contentType;
    /**
     * 发送内容
     */
    private String content;
    

    public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getOrgID() {
		return orgID;
	}
	public void setOrgID(Integer orgID) {
		this.orgID = orgID;
	}
	public Byte getSmsType() {
		return smsType;
	}
	public void setSmsType(Byte smsType) {
		this.smsType = smsType;
	}
	public Byte getPriority() {
		return priority;
	}
	public void setPriority(Byte priority) {
		this.priority = priority;
	}
	public Byte getContentType() {
		return contentType;
	}
	public void setContentType(Byte contentType) {
		this.contentType = contentType;
	}
	public Integer getSSDetailID() {
        return SSDetailID;
    }
    public void setSSDetailID(Integer SSDetailID) {
        this.SSDetailID = SSDetailID;
    }
    public Integer getSSendID() {
        return SSendID;
    }
    public void setSSendID(Integer SSendID) {
        this.SSendID = SSendID;
    }
    public String getMemberID() {
        return memberID;
    }
    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }
    public String getRecvNumber() {
        return recvNumber;
    }
    public void setRecvNumber(String recvNumber) {
        this.recvNumber = recvNumber;
    }
    public Date getSendTime() {
        return sendTime;
    }
    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }
    public Byte getSendStatus() {
        return sendStatus;
    }
    public void setSendStatus(Byte sendStatus) {
        this.sendStatus = sendStatus;
    }
    public Date getRecvTime() {
        return recvTime;
    }
    public void setRecvTime(Date recvTime) {
        this.recvTime = recvTime;
    }
    public String getFailReason() {
        return failReason;
    }
    public void setFailReason(String failReason) {
        this.failReason = failReason;
    }
    public Integer getFailCount() {
        return failCount;
    }
    public void setFailCount(Integer failCount) {
        this.failCount = failCount;
    }
    public Integer getCreateID() {
        return createID;
    }
    public void setCreateID(Integer createID) {
        this.createID = createID;
    }
    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public Integer getUpdateID() {
        return updateID;
    }
    public void setUpdateID(Integer updateID) {
        this.updateID = updateID;
    }
    public Date getUpdateTime() {
        return updateTime;
    }
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}