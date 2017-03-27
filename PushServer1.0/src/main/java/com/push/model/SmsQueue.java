package com.push.model;

import java.util.Date;

import javax.persistence.Entity;


/**
 * @ClassName:     SmsQueue.java 
 * @Description:   待发送短信队列实体
 * @author         谢美团  
 * @version        V1.0   
 * @Date           2015年12月9日 上午11:09:40
*****/
@Entity
public class SmsQueue {
	
	private int serverId;	//组织id 

	private String msgId;	//消息的id   msg_id
	
	private String phones; //发送的号码，多个时以 ，隔开
	
	private String sendType; //发送类型 ，1：短信，2：语音
	
	private String content; //短信内容
	
	private int level; //优先级，1：紧急，2：较高，3：普通，4：较低，5：最低
	
	private Date sendTime;//发送时间
	
	public int getServerId() {
		return serverId;
	}
	public void setServerId(int serverId) {
		this.serverId = serverId;
	}
	public String getMsgId() {
		return msgId;
	}
	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}
	public String getPhones() {
		return phones;
	}
	public void setPhones(String phones) {
		this.phones = phones;
	}
	public String getSendType() {
		return sendType;
	}
	public void setSendType(String sendType) {
		this.sendType = sendType;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public Date getSendTime() {
		return sendTime;
	}
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}
	@Override
	public String toString() {
		return "SmsQueue [msgId=" + msgId + ", phones=" + phones
				+ ", sendType=" + sendType + ", content=" + content
				+ ", level=" + level + ", sendTime=" + sendTime + "]";
	}

}
