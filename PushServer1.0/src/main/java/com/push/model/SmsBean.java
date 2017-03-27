package com.push.model;

import java.util.Date;

import javax.persistence.Entity;



/**
 * @ClassName:     SmsBean.java 
 * @Description:   短信语音持久化信息实体
 * @author         谢美团  
 * @version        V1.0   
 * @Date           2015年12月10日 上午9:49:50
*****/
@Entity
public class SmsBean {

	private int id;	//主键
	private int serverId;	//组织id 
	private String msgId;	//消息的id   msg_id
	private String serverName;	//组织名称
	private String type; //短信类型：1：会员注册，2：忘记密码
	private String sendType; //发送类型 ，1：短信，2：语音
	private String content; //短信内容
	private int level; //优先级，1：紧急，2：较高，3：普通，4：较低，5：最低
	private int status; //发送状态，1：待发送，2：已发送(发送到网关)，3：发送成功（发送到电信），4：发送到网关失败，5：发送到电信失败'
	private Date receiveTime;//接收时间
	private Date sendTime;//发送时间
	private Date updateDate;//更新时间
	private Date createDate;//创建时间
	private String createBy;//创建者
	private String updateBy;//更新者
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getServerId() {
		return serverId;
	}
	public void setServerId(int serverId) {
		this.serverId = serverId;
	}
	public String getServerName() {
		return serverName;
	}
	public void setServerName(String serverName) {
		this.serverName = serverName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getReceiveTime() {
		return receiveTime;
	}
	public void setReceiveTime(Date receiveTime) {
		this.receiveTime = receiveTime;
	}
	public Date getSendTime() {
		return sendTime;
	}
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public String getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	public String getMsgId() {
		return msgId;
	}
	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}
	
	
	
	
	
}
