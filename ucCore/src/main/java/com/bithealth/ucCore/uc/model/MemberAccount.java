/*
 * MemberAccount.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-08-18 Created
 */
package com.bithealth.ucCore.uc.model;

import com.bithealth.sdk.core.generic.GenericModel;
import java.util.Date;

/**
 * 会员统一登录表
 * 
 * @author ${user}
 * @version 1.0 2016-08-18
 */
public class MemberAccount extends GenericModel {

    /**
     * 记录ID
     */
    private Integer logID;
    /**
     * [1.1]会员ID
     */
    private String memberID;
    /**
     * 会员账号
     */
    private String account;
    /**
     * 账号类型：1-手机号码；2-邮件；3-身份证
     */
    private Byte accountType;
    /**
     * 服务ID(引用appRecode.app_server.id)
     */
    private Integer serverId;
    /**
     * 记录创建时间
     */
    private Date createTime;
    /**
     * 记录更新时间
     */
    private Date updateTime;
    public MemberAccount(){
    	
    }
    public MemberAccount(String memberID, String account, Byte accountType) {
    	this.memberID = memberID;
    	this.account = account;
    	this.accountType = accountType;
    }
    
    public Integer getLogID() {
        return logID;
    }
    public void setLogID(Integer logID) {
        this.logID = logID;
    }
    public String getMemberID() {
        return memberID;
    }
    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }
    public String getAccount() {
        return account;
    }
    public void setAccount(String account) {
        this.account = account;
    }
    public Byte getAccountType() {
        return accountType;
    }
    public void setAccountType(Byte accountType) {
        this.accountType = accountType;
    }
    public Integer getServerId() {
        return serverId;
    }
    public void setServerId(Integer serverId) {
        this.serverId = serverId;
    }
    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public Date getUpdateTime() {
        return updateTime;
    }
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}