/*
 * SmsSearchParams.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-11-28 Created
 */
package com.bithealth.msgCenterCore.model;

import java.util.Date;

import org.springframework.context.annotation.ComponentScan.Filter;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 短信记录查询参数实体
 * 
 * @author ${user}
 * @version 1.0 2016-11-28
 */
public class SmsSearchParams{

    /**
     * 服务器id
     */
	private Integer serverID;
    /**
     * 组织id集合，多个以逗号隔开
     */
	private String orgIDs;
    /**
     * 查询开始时间
     */
	 @JSONField (format="yyyy-MM-dd HH:mm:ss")  
	private Date startTime;
    /**
     * 查询结束时间
     */
    @JSONField (format="yyyy-MM-dd HH:mm:ss")  
	private Date endTime;
	
    /**
     * 短信类型：1-会员注册，2-忘记密码，3-邀请短信
     */
	private Integer smsType;
	
    /**
     * 接收号码
     */
    private String recvNumber;

    /**
     * 发送状态：1-待发送，2-已发送(至网关)，3-发送成功，4-发送失败
     */
    private Byte sendStatus;
    
    
    private int pageNo = 1;
    
    private int pageSize = 10;
    
    private String smsTypeName;
    
    private String sendTimeStr;
    
    
	public String getSmsTypeName() {
		return smsTypeName;
	}

	public void setSmsTypeName(String smsTypeName) {
		this.smsTypeName = smsTypeName;
	}

	public String getSendTimeStr() {
		return sendTimeStr;
	}

	public void setSendTimeStr(String sendTimeStr) {
		this.sendTimeStr = sendTimeStr;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getServerID() {
		return serverID;
	}

	public void setServerID(Integer serverID) {
		this.serverID = serverID;
	}

	public String getOrgIDs() {
		return orgIDs;
	}

	public void setOrgIDs(String orgIDs) {
		this.orgIDs = orgIDs;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Integer getSmsType() {
		return smsType;
	}

	public void setSmsType(Integer smsType) {
		this.smsType = smsType;
	}

	public String getRecvNumber() {
		return recvNumber;
	}

	public void setRecvNumber(String recvNumber) {
		this.recvNumber = recvNumber;
	}

	public Byte getSendStatus() {
		return sendStatus;
	}

	public void setSendStatus(Byte sendStatus) {
		this.sendStatus = sendStatus;
	}
  

  
}