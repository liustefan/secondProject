
package com.bithealth.centCore.facade.model;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;



/**
 * 类名称: MsgPushData  
 * 功能描述: 推送业务数据实体类  
 * 日期: 2016年10月11日 下午4:47:17 
 * 
 * @author 谢美团
 * @version  
 */
public class MsgPushData  {
	
	private String msgType;//消息类型
	
	private String lastSourceID; //其他业务类型表的数据主键
	
	@JSONField (format="yyyy-MM-dd HH:mm:ss") 
	private Date createTime;
	
	private String lastContent;//手机通栏弹出的内容

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public String getLastSourceID() {
		return lastSourceID;
	}

	public void setLastSourceID(String lastSourceID) {
		this.lastSourceID = lastSourceID;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getLastContent() {
		return lastContent;
	}

	public void setLastContent(String lastContent) {
		this.lastContent = lastContent;
	}
	
	
	
	
	
	
}