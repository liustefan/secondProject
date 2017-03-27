/*
 * SmsSearchParams.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-11-28 Created
 */
package com.bithealth.centCore.sms.model;


/**
 * 短信发送参数实体
 * 
 * @author ${user}
 * @version 1.0 2016-11-28
 */
public class SmsSendParams{

    /**
     * 服务器id
     */
	private Integer serverID;
    /**
     * 短信类型：1-会员注册，2-忘记密码，3-邀请短信
     */
	private Integer smsType;
    /**
     * 优先级：1-紧急，2-较高，3-普通，4-较低，5-最低
     */
    private Byte priority;
    /**
     * 优接收号码,多个时已逗号隔开，如1,6,4。限制一个请求最多200个号码。
     */
    private String recvNumbers;
    /**
     * 发送内容
     */
    private String content;
    /**
     * 发送内容类别：1-文本，2-语音
     */
    private Byte contentType;
    /**
     * 发送组织的id path
     */
    private String orgPath;
    
    private String sendTime;

	public String getSendTime() {
		return sendTime;
	}

	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}

	public Integer getServerID() {
		return serverID;
	}

	public void setServerID(Integer serverID) {
		this.serverID = serverID;
	}

	public Integer getSmsType() {
		return smsType;
	}

	public void setSmsType(Integer smsType) {
		this.smsType = smsType;
	}

	public Byte getPriority() {
		return priority;
	}

	public void setPriority(Byte priority) {
		this.priority = priority;
	}

	public String getRecvNumbers() {
		return recvNumbers;
	}

	public void setRecvNumbers(String recvNumbers) {
		this.recvNumbers = recvNumbers;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Byte getContentType() {
		return contentType;
	}

	public void setContentType(Byte contentType) {
		this.contentType = contentType;
	}

	public String getOrgPath() {
		return orgPath;
	}

	public void setOrgPath(String orgPath) {
		this.orgPath = orgPath;
	}

}