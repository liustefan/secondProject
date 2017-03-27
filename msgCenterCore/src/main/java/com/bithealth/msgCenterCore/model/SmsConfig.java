/*
 * SmsConfig.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-12-05 Created
 */
package com.bithealth.msgCenterCore.model;

import java.text.ParseException;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.bithealth.sdk.common.utils.TimeUtil;

/**
 * [3.0]短信配置
 * 
 * @author ${user}
 * @version 1.0 2016-12-05
 */
public class SmsConfig {

    /**
     * 短信配置ID
     */
    private Integer SCfgID;
    /**
     * 服务器ID(引用app_server.id)
     */
    private Integer serverID;
    /**
     * 组织ID
     */
    private Integer orgID;
    /**
     * 账号
     */
    private String account;
    /**
     * 密码
     */
    private String passwd;
    /**
     * 签名
     */
    private String signature;
    /**
     * 总条数限制
     */
    private Integer totalSendLimit;
    /**
     * 每日最大发送条数
     */
    private Integer dailyMaxSend;
    /**
     * 同一个会员每日可接受条数
     */
    private Short memberDailyMaxRecv;
    /**
     * 同一个会员每日允许重复内容条数
     */
    private Byte memberDailyMaxRepl;
    /**
     * 短信发送开始时间
     */
    @JSONField (format="HH:mm:ss")  
    private Date sendStartTime;
    /**
     * 短信发送结束时间
     */
    @JSONField (format="HH:mm:ss")  
    private Date sendEndTime;
    /**
     * 验证码模板编号
     */
    private String captchaTempletNo;
    /**
     * 邀请短信模板编号
     */
    private String inviteSMSTempletNo;
    /**
     * 测试短信模板编号
     */
    private String testSMSTempletNo;
    /**
     * 创建医生ID
     */
    private Integer createID;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新医生ID
     */
    private Integer updateID;
    /**
     * 更新时间
     */
    private Date updateTime;
    
    
    //额外增加的参数
    private Integer SSendID;
    
    private String sendStartTimeStr;
    private String sendEndTimeStr;
    
    
    private String orgName;
    
    

    public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getSendStartTimeStr() {
		return sendStartTimeStr;
	}
	public void setSendStartTimeStr(String sendStartTimeStr) {
		this.sendStartTimeStr = sendStartTimeStr;
		try {
			this.sendStartTime = TimeUtil.parseTime(sendStartTimeStr);
		} catch (ParseException e) {
		}
	}
	public String getSendEndTimeStr() {
		return sendEndTimeStr;
	}
	public void setSendEndTimeStr(String sendEndTimeStr) {
		this.sendEndTimeStr = sendEndTimeStr;
		try {
			this.sendEndTime =  TimeUtil.parseTime(sendEndTimeStr);
		} catch (ParseException e) {
		}
	}
	public Integer getSSendID() {
		return SSendID;
	}
	public void setSSendID(Integer sSendID) {
		SSendID = sSendID;
	}
	
	public String getTestSMSTempletNo() {
		return testSMSTempletNo;
	}
	public void setTestSMSTempletNo(String testSMSTempletNo) {
		this.testSMSTempletNo = testSMSTempletNo;
	}
	public Integer getSCfgID() {
        return SCfgID;
    }
    public void setSCfgID(Integer SCfgID) {
        this.SCfgID = SCfgID;
    }
    public Integer getServerID() {
        return serverID;
    }
    public void setServerID(Integer serverID) {
        this.serverID = serverID;
    }
    public Integer getOrgID() {
        return orgID;
    }
    public void setOrgID(Integer orgID) {
        this.orgID = orgID;
    }
    public String getAccount() {
        return account;
    }
    public void setAccount(String account) {
        this.account = account;
    }
    public String getPasswd() {
        return passwd;
    }
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
    public String getSignature() {
        return signature;
    }
    public void setSignature(String signature) {
        this.signature = signature;
    }
    public Integer getTotalSendLimit() {
        return totalSendLimit;
    }
    public void setTotalSendLimit(Integer totalSendLimit) {
        this.totalSendLimit = totalSendLimit;
    }
    public Integer getDailyMaxSend() {
        return dailyMaxSend;
    }
    public void setDailyMaxSend(Integer dailyMaxSend) {
        this.dailyMaxSend = dailyMaxSend;
    }
    public Short getMemberDailyMaxRecv() {
        return memberDailyMaxRecv;
    }
    public void setMemberDailyMaxRecv(Short memberDailyMaxRecv) {
        this.memberDailyMaxRecv = memberDailyMaxRecv;
    }
    public Byte getMemberDailyMaxRepl() {
        return memberDailyMaxRepl;
    }
    public void setMemberDailyMaxRepl(Byte memberDailyMaxRepl) {
        this.memberDailyMaxRepl = memberDailyMaxRepl;
    }
    public Date getSendStartTime() {
        return sendStartTime;
    }
    public void setSendStartTime(Date sendStartTime) {
        this.sendStartTime = sendStartTime;
    }
    public Date getSendEndTime() {
        return sendEndTime;
    }
    public void setSendEndTime(Date sendEndTime) {
        this.sendEndTime = sendEndTime;
    }
    public String getCaptchaTempletNo() {
        return captchaTempletNo;
    }
    public void setCaptchaTempletNo(String captchaTempletNo) {
        this.captchaTempletNo = captchaTempletNo;
    }
    public String getInviteSMSTempletNo() {
        return inviteSMSTempletNo;
    }
    public void setInviteSMSTempletNo(String inviteSMSTempletNo) {
        this.inviteSMSTempletNo = inviteSMSTempletNo;
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