package com.push.model;

import java.io.Serializable;
import java.util.Date;


/**
 * The persistent class for the hk_push_messenger database table.
 * 
 */
public class HkPushMessenger implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;

	private String createBy;

	private Date createDate;

	private String messenger;

	private String msgId;

	private String updateBy;

	private Date updateDate;

	private String sender;
	
	public HkPushMessenger() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCreateBy() {
		return this.createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getMessenger() {
		return this.messenger;
	}

	public void setMessenger(String messenger) {
		this.messenger = messenger;
	}

	public String getMsgId() {
		return this.msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	public String getUpdateBy() {
		return this.updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

}