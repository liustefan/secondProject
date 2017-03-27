/*
 * KindlyReminder.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-08-24 Created
 */
package com.bithealth.centCore.care.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.bithealth.sdk.core.generic.GenericModel;

import java.util.Date;

/**
 * [2.1]温馨提示表
 * 
 * @author ${user}
 * @version 1.0 2016-08-24
 */
public class KindlyReminderResult {

	/**
     * 记录ID
     */
    private Integer logID;
	/**
     * 发送类型：1-医生，2-会员
     */
    private Byte sendType;
    /**
     * 发送者
     */
    private String sender;
    /**
     * 接收者(会员)
     */
    private String receiver;
    /**
     * 内容
     */
    private String content;
    /**
     * 创建时间
     */
    @JSONField (format="yyyy-MM-dd HH:mm:ss")  
    private Date createTime;
    /**
     * 定时发送时间
     */
    @JSONField (format="yyyy-MM-dd HH:mm:ss")  
    private Date scheduleTime;
    
    /**
     * 消息类型，0-all,1-即时消息2-定时消息，默认为0
     */
    private int msgType = 0;
    
    private String senderName;
    
	public String getSenderName() {
		return senderName;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	public Integer getLogID() {
		return logID;
	}
	public void setLogID(Integer logID) {
		this.logID = logID;
	}
	public int getMsgType() {
		return msgType;
	}
	public void setMsgType(int msgType) {
		this.msgType = msgType;
	}

    public Byte getSendType() {
        return sendType;
    }
    public void setSendType(Byte sendType) {
        this.sendType = sendType;
    }
    public String getSender() {
        return sender;
    }
    public void setSender(String sender) {
        this.sender = sender;
    }
    public String getReceiver() {
        return receiver;
    }
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public Date getScheduleTime() {
        return scheduleTime;
    }
    public void setScheduleTime(Date scheduleTime) {
        this.scheduleTime = scheduleTime;
    }
}