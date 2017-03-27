/*
 * FamilyNews.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-10-26 Created
 */
package com.bithealth.centCore.care.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.bithealth.sdk.core.generic.GenericModel;
import java.util.Date;

/**
 * [1.1]关注的亲友动态表
 * 
 * @author ${user}
 * @version 1.0 2016-10-26
 */
public class FamilyNews extends GenericModel {

    /**
     * 记录ID
     */
    private Integer logID;
    /**
     * 消息类型：10-测量数据(停用)，11-体检随访，12-高血压随访，13-II型糖尿病随访，15-血压测量，16-血糖测量，17-心电测量，18-3合1测量
     */
    private Byte msgType;
    /**
     * 发送者
     */
    private String sender;
    /**
     * 接收者
     */
    private String receiver;
    /**
     * 消息来源ID
     */
    private Long sourceID;
    /**
     * 消息内容
     */
    private String content;
    /**
     * 是否发送：0-否，1-是
     */
    private Byte isSend;
    /**
     * 创建时间
     */
    @JSONField (format="yyyy-MM-dd HH:mm:ss")  
    private Date createTime;
    /**
     * 更新时间
     */
    @JSONField (format="yyyy-MM-dd HH:mm:ss")  
    private Date updateTime;
    
    
    //额外增加的参数
    
    private String headAddress; //头像
    private String url; //服务地址
    private Integer serverId; //服务id
    
    //额外增加的参数
    /**
     * 阅读状态，0：已读，1：未读
     */
    private Integer number = 0;
    
    public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Integer getServerId() {
		return serverId;
	}
	public void setServerId(Integer serverId) {
		this.serverId = serverId;
	}
	public String getHeadAddress() {
		return headAddress;
	}
	public void setHeadAddress(String headAddress) {
		this.headAddress = headAddress;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getLogID() {
        return logID;
    }
    public void setLogID(Integer logID) {
        this.logID = logID;
    }
    public Byte getMsgType() {
        return msgType;
    }
    public void setMsgType(Byte msgType) {
        this.msgType = msgType;
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
    public Long getSourceID() {
        return sourceID;
    }
    public void setSourceID(Long sourceID) {
        this.sourceID = sourceID;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public Byte getIsSend() {
        return isSend;
    }
    public void setIsSend(Byte isSend) {
        this.isSend = isSend;
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