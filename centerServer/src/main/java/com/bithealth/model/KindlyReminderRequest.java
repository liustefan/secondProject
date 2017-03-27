/*
 * KindlyReminder.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-08-24 Created
 */
package com.bithealth.model;

import com.bithealth.sdk.core.generic.GenericModel;

import java.util.Date;
import java.util.List;

/**
 * [2.1]温馨提示表
 * 
 * @author ${user}
 * @version 1.0 2016-08-24
 */
public class KindlyReminderRequest extends GenericModel {

	private static final long serialVersionUID = 1L;

   public KindlyReminderRequest() {
	}
   
	/**
     * 记录ID
     */
    private Integer logID;
 
	/**
     * 发送类型：1-医生，2-会员
     */
    private Integer sendType;
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
    private String createTime;
    /**
     * 定时发送时间
     */
    private String scheduleTime;
    
    /**
     * 发送者GUID
     */
    private String senderGUID;
    /**
     * 接收者(会员)GUID
     */
    private String receiverGUIDList;
    
    /**
     * 消息类型，0-all,1-即时消息2-定时消息，默认为0
     */
    private int msgType = 0;
    
    private int pageNow = 1;
    
    private int pageSize = 10;
    
    private String senderName;

    public String getSenderName() {
		return senderName;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
    
	public int getPageNow() {
		return pageNow;
	}

	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}
 

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getSenderGUID() {
		return senderGUID;
	}
	public void setSenderGUID(String senderGUID) {
		this.senderGUID = senderGUID;
	}

	public String getReceiverGUIDList() {
		return receiverGUIDList;
	}

	public void setReceiverGUIDList(String receiverGUIDList) {
		this.receiverGUIDList = receiverGUIDList;
	}

	public int getMsgType() {
		return msgType;
	}
	public void setMsgType(int msgType) {
		this.msgType = msgType;
	}
	public Integer getLogID() {
        return logID;
    }
    public void setLogID(Integer logID) {
        this.logID = logID;
    }
  
    public Integer getSendType() {
		return sendType;
	}

	public void setSendType(Integer sendType) {
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
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getScheduleTime() {
		return scheduleTime;
	}
	public void setScheduleTime(String scheduleTime) {
		this.scheduleTime = scheduleTime;
	}

}