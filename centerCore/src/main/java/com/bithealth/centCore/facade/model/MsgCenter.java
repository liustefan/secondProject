/*
 * MessageCenter.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-08-29 Created
 */
package com.bithealth.centCore.facade.model;

import java.util.Date;


public class MsgCenter  {

    /**
     * 消息类型：1-温馨提示，2-我的咨询，3-单项报告，4-汇总报告，5-单份答卷审核，6-组合答卷审核，7-关注亲友，8-健康资讯，9-广告，10-测量数据，11-体检随访，12-高血压随访，13-II型糖尿病随访
     */
    private Byte msgtype;
    /**
     * 发送类型：0-系统，1-医生，2-会员
     */
    private Byte sendtype;
    /**
     * 发送者guid
     */
    private String sender;
 
    /**
     * 接收类型：1-医生，2-会员，3-tag
     */
    private Byte receivetype;
    /**
     * 接收者guid或tag内容
     */
    private String receiver;
    /**
     * 最新的消息来源ID
     */
    private Long lastsourceid;
    /**
     * 最新的消息内容摘要，体检和随访的摘要格式中使用 (??) 代表发送者和接收者的关系。 
     */
    private String lastcontent;
    
    /**
     * [3.0]最新的消息内容通知栏
     */
    private String lastContentNotice;

    /**
     * 计划发送时间，未填则即时发送
     */
    private Date scheduletime;
    
    private String senderName;
    

    public String getLastContentNotice() {
		return lastContentNotice;
	}
	public void setLastContentNotice(String lastContentNotice) {
		this.lastContentNotice = lastContentNotice;
	}
	public String getSenderName() {
		return senderName;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

    public Byte getReceivetype() {
		return receivetype;
	}
	public void setReceivetype(Byte receivetype) {
		this.receivetype = receivetype;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public Byte getMsgtype() {
        return msgtype;
    }
    public void setMsgtype(Byte msgtype) {
        this.msgtype = msgtype;
    }
    public Byte getSendtype() {
        return sendtype;
    }
    public void setSendtype(Byte sendtype) {
        this.sendtype = sendtype;
    }
    public String getSender() {
        return sender;
    }
    public void setSender(String sender) {
        this.sender = sender;
    }

    public Long getLastsourceid() {
        return lastsourceid;
    }
    public void setLastsourceid(Long lastsourceid) {
        this.lastsourceid = lastsourceid;
    }
    public String getLastcontent() {
        return lastcontent;
    }
    public void setLastcontent(String lastcontent) {
        this.lastcontent = lastcontent;
    }

    public Date getScheduletime() {
        return scheduletime;
    }
    public void setScheduletime(Date scheduletime) {
        this.scheduletime = scheduletime;
    }

}