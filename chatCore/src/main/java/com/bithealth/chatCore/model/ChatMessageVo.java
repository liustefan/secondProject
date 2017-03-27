/*
 * ChatMessage.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-09-08 Created
 */
package com.bithealth.chatCore.model;

import com.bithealth.sdk.core.generic.GenericModel;

import java.util.Date;

/**
 * [2.1]聊天表vo
 * 
 * @author ${liuxiaoqin}
 * @version 1.0 2016-09-08
 */
public class ChatMessageVo extends GenericModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2291554898957663979L;
	/**
     * 记录ID
     */
    private Integer _logid;
    /**
     * 发送类型：1-医生，2-会员
     */
    private Byte sendType;
    /**
     * 发送者
     */
    private Integer sender;
    /**
     * 发送者GUID
     */
    private String senderGUID;
    /**
     * 发送时间
     */
    private Date sendTime;
    /**
     * 接收类型：1-医生，2-会员
     */
    private Byte receiveType;
    /**
     * 接收者
     */
    private Integer receiver;
    /**
     * 接收者GUID
     */
    private String receiverGUID;
    /**
     * 接收时间
     */
    private Date receiveTime;
    /**
     * 内容类别：1-文本，2-图片，3-音频，4-视频
     */
    private Byte contentType;
    /**
     * 内容
     */
    private String content;
    
    /**
     * 用户名：医生或者会员
     */
    private String userName;
    
    /**
     * 性别
     */
    private String gender;
    
    /**
     * 科室（医生特有）
     */
    private String workdepart;
    
    /**
     * 生日
     */
    private Date birthDate;
    
    /**
     * 头像地址
     */
    private String headaddress;
    
    /**
     * 用户guid
     */
    private String userGUID;
    
    /**
     * 用户id
     */
    private Integer userId;
    
    /**
     * 医生或者会员是否有回复（值为2的时候有回复;1或者NULL为没有回复）
     */
    private Integer hasReply;
    

	public Integer get_logid() {
		return _logid;
	}

	public void set_logid(Integer _logid) {
		this._logid = _logid;
	}

	public Byte getSendType() {
		return sendType;
	}

	public void setSendType(Byte sendType) {
		this.sendType = sendType;
	}

	public Integer getSender() {
		return sender;
	}

	public void setSender(Integer sender) {
		this.sender = sender;
	}

	public String getSenderGUID() {
		return senderGUID;
	}

	public void setSenderGUID(String senderGUID) {
		this.senderGUID = senderGUID;
	}

	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	public Byte getReceiveType() {
		return receiveType;
	}

	public void setReceiveType(Byte receiveType) {
		this.receiveType = receiveType;
	}

	public Integer getReceiver() {
		return receiver;
	}

	public void setReceiver(Integer receiver) {
		this.receiver = receiver;
	}

	public String getReceiverGUID() {
		return receiverGUID;
	}

	public void setReceiverGUID(String receiverGUID) {
		this.receiverGUID = receiverGUID;
	}

	public Date getReceiveTime() {
		return receiveTime;
	}

	public void setReceiveTime(Date receiveTime) {
		this.receiveTime = receiveTime;
	}

	public Byte getContentType() {
		return contentType;
	}

	public void setContentType(Byte contentType) {
		this.contentType = contentType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getWorkdepart() {
		return workdepart;
	}

	public void setWorkdepart(String workdepart) {
		this.workdepart = workdepart;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getHeadaddress() {
		return headaddress;
	}

	public void setHeadaddress(String headaddress) {
		this.headaddress = headaddress;
	}

	public String getUserGUID() {
		return userGUID;
	}

	public void setUserGUID(String userGUID) {
		this.userGUID = userGUID;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getHasReply() {
		return hasReply;
	}

	public void setHasReply(Integer hasReply) {
		this.hasReply = hasReply;
	}
    
    
    
}