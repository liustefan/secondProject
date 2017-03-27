/*
 * KindlyReminder.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-08-24 Created
 */
package com.bithealth.careCore.facade.model;

import java.util.ArrayList;
import java.util.Date;

import com.bithealth.sdk.core.feature.orm.mybatis.Page;

/**
 * [2.1]温馨提示表
 * 
 * @author ${user}
 * @version 1.0 2016-08-24
 */
public class KindlyReminder extends Page {

	private static final long serialVersionUID = 1L;

   public KindlyReminder() {
		super();
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
     * 内容
     */
    private String content;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 定时发送时间
     */
    private Date scheduleTime;
    
    /**
     * 发送者GUID
     */
    private String senderGUID;
    /**
     * 接收者(会员)GUIDList
     */
    private ArrayList<String> receiverGUIDList;
    
    /**
     * 消息类型，0-all,1-即时消息2-定时消息，默认为0
     */
    private int msgType = 0;
    
    /**
     * 接收者(会员)GUID
     */
    private String receiverGUID;
    
    /**
     * 查询开始时间 格式： yyyy-MM-dd HH:mm:ss
     */ 
    private String startDate; 
    /**
     * 查询结束时间  格式： yyyy-MM-dd HH:mm:ss
     */
    private String endDate;
    
    private String senderName;
    
	public String getSenderName() {
		return senderName;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getReceiverGUID() {
		return receiverGUID;
	}
	public void setReceiverGUID(String receiverGUID) {
		this.receiverGUID = receiverGUID;
	}
	public String getSenderGUID() {
		return senderGUID;
	}
	public void setSenderGUID(String senderGUID) {
		this.senderGUID = senderGUID;
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

	public ArrayList<String> getReceiverGUIDList() {
		return receiverGUIDList;
	}

	public void setReceiverGUIDList(ArrayList<String> receiverGUIDList) {
		this.receiverGUIDList = receiverGUIDList;
	}
    
}