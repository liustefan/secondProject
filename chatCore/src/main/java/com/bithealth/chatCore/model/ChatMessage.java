/*
 * ChatMessage.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-12-20 Created
 */
package com.bithealth.chatCore.model;

import com.bithealth.sdk.core.generic.GenericModel;
import java.util.Date;

import org.apache.commons.lang.time.DateUtils;
import com.bithealth.memberCore.member.model.Member;
import com.bithealth.sdk.common.utils.TimeUtil;
import com.bithealth.sdk.core.generic.GenericModel;

/**
 * [2.1]聊天表
 * 
 * @author ${user}
 * @version 1.0 2016-12-20
 */
public class ChatMessage extends GenericModel {

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
     * 发送者名字
     */
    private String senderName;
    
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
    
        
    private Date startSendtime;
    
    private Date endSendtime;
    
    private Member member;
    
    private String contentStr;
    
    private String lastContentNotice;
    
    /** 
     * 
//    [3.0]引用类型：1-健教，2-复诊，3-测量，4-单份问卷，5-组合问卷，6-高血压随访(公卫)，7-糖尿病随访(公卫)
     */
    private Byte refType;
    /**
     * [3.0]引用相关表记录ID
     */
    private Long refID;
    /**
     * [3.0]引用对应的状态：(问卷调查)1-未答、2-已答、3-已审核、4-已撤回
     */
    private Byte refStatus;

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
    
    public Date getStartSendtime() {
		return startSendtime;
	}
	public void setStartSendtime(Date startSendtime) {
		this.startSendtime = startSendtime;
	}
	public Date getEndSendtime() {
		return endSendtime;
	}
	public void setEndSendtime(Date endSendtime) {
		this.endSendtime = endSendtime;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
    
	public String getValidSendTime(){
		if(DateUtils.isSameDay(sendTime, TimeUtil.now())){
			return TimeUtil.formatTime(sendTime);
		}else{
			return TimeUtil.formatDatetime2(sendTime);
		}
	}
	public String getContentStr() {
		return contentStr;
	}
	public void setContentStr(String contentStr) {
		this.contentStr = contentStr;
	}
	public String getSenderName() {
		return senderName;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	
    public Byte getRefType() {
        return refType;
    }
    public void setRefType(Byte refType) {
        this.refType = refType;
    }
    public Long getRefID() {
        return refID;
    }
    public void setRefID(Long refID) {
        this.refID = refID;
    }
    public Byte getRefStatus() {
        return refStatus;
    }
    public void setRefStatus(Byte refStatus) {
        this.refStatus = refStatus;
    }
	public String getLastContentNotice() {
		return lastContentNotice;
	}
	public void setLastContentNotice(String lastContentNotice) {
		this.lastContentNotice = lastContentNotice;
	}
    
    
}