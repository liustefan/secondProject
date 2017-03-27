/*
 * SmsSend.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-11-28 Created
 */
package com.bithealth.centCore.sms.model;

import com.bithealth.sdk.core.generic.GenericModel;
import java.util.Date;

/**
 * [3.0]短信发送
 * 
 * @author ${user}
 * @version 1.0 2016-11-28
 */
public class SmsSend extends GenericModel {

    /**
     * 短信发送ID
     */
    private Integer SSendID;
    /**
     * 服务器ID(引用app_server.id)
     */
    private Integer serverID;
    /**
     * 组织ID
     */
    private Integer orgID;
    /**
     * 组织名称
     */
    private String orgName = "";
    /**
     * 账号
     */
    private String account;
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
    /**
     * 创建者ID，0-系统
     */
    private Integer createID;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新者ID，0-系统
     */
    private Integer updateID;
    /**
     * 更新时间
     */
    private Date updateTime;

    public Integer getSSendID() {
        return SSendID;
    }
    public void setSSendID(Integer SSendID) {
        this.SSendID = SSendID;
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
    public String getOrgName() {
        return orgName;
    }
    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }
    public String getAccount() {
        return account;
    }
    public void setAccount(String account) {
        this.account = account;
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
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
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