package com.push.model;

import java.util.Date;

import javax.persistence.Entity;


/**
 * @ClassName:     SmsRequestBean.java 
 * @Description:   请求参数实体类
 * @author         谢美团  
 * @version        V1.0   
 * @Date           2015年12月10日 上午9:50:39
*****/
@Entity
public class SmsRequestBean {

	private int serverId;	//组织id 
	
	private String content; //短信内容
	
	private String phones;	//发送的号码，多个时以 ，隔开
	
	private String businessType; //此次发送的业务类型,1:会员注册，2：忘记密码
	
	private String sendType; //发送类型 ，1：短信，2：语音
	
	private int level; //优先级，1：紧急，2：较高，3：普通，4：较低，5：最低
	
	public int getServerId() {
		return serverId;
	}
	public void setServerId(int serverId) {
		this.serverId = serverId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPhones() {
		return phones;
	}
	public void setPhones(String phones) {
		this.phones = phones;
	}
	public String getBusinessType() {
		return businessType;
	}
	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}
	public String getSendType() {
		return sendType;
	}
	public void setSendType(String sendType) {
		this.sendType = sendType;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}


	
	
}
