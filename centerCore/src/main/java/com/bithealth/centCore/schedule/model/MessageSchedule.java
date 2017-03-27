/*
 * MessageSchedule.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2017-02-06 Created
 */
package com.bithealth.centCore.schedule.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.bithealth.sdk.core.generic.GenericModel;

import java.util.Date;

/**
 * [3.0]消息计划表
 * 
 * @author ${user}
 * @version 1.0 2017-02-06
 */
public class MessageSchedule extends GenericModel {

    /**
     * 记录ID
     */
    private Long logID;
    /**
     * 消息类型：1-温馨提示，2-我的咨询(医患沟通)，7-关注亲友，8-健康资讯，9-广告，14-关注的亲友动态；<[3.0]废弃：3/4-单项/汇总报告，5/6-单份/组合答卷审核，10-测量数据，19/20-单份/组合问卷发放>
     */
    private Byte msgType;
    /**
     * 发送类型：1-医生，2-会员
     */
    private Byte sendType;
    /**
     * 发送者guid
     */
    private String sender;
    /**
     * 接收类型：1-医生，2-会员，3-tag
     */
    private Byte receiveType;
    /**
     * 接收者guid或tag内容
     */
    private String receiver;
    /**
     * 最新的消息来源ID
     */
    private Long lastSourceID;
    /**
     * 最新的消息内容摘要
     */
    private String lastContent;
    /**
     * 最新的消息内容通知栏
     */
    private String lastContentNotice;
    /**
     * 计划发送时间
     */
    @JSONField (format="yyyy-MM-dd HH:mm:ss")  
    private Date scheduleTime;
    /**
     * 创建时间
     */
    @JSONField (format="yyyy-MM-dd HH:mm:ss")  
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;

    public Long getLogID() {
        return logID;
    }
    public void setLogID(Long logID) {
        this.logID = logID;
    }
    public Byte getMsgType() {
        return msgType;
    }
    public void setMsgType(Byte msgType) {
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
    public Byte getReceiveType() {
        return receiveType;
    }
    public void setReceiveType(Byte receiveType) {
        this.receiveType = receiveType;
    }
    public String getReceiver() {
        return receiver;
    }
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }
    public Long getLastSourceID() {
        return lastSourceID;
    }
    public void setLastSourceID(Long lastSourceID) {
        this.lastSourceID = lastSourceID;
    }
    public String getLastContent() {
        return lastContent;
    }
    public void setLastContent(String lastContent) {
        this.lastContent = lastContent;
    }
    public String getLastContentNotice() {
        return lastContentNotice;
    }
    public void setLastContentNotice(String lastContentNotice) {
        this.lastContentNotice = lastContentNotice;
    }
    public Date getScheduleTime() {
        return scheduleTime;
    }
    public void setScheduleTime(Date scheduleTime) {
        this.scheduleTime = scheduleTime;
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