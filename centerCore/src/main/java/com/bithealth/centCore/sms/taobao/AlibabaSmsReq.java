/*
 * AlibabaSmsReq.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-12-02 Created
 */
package com.bithealth.centCore.sms.taobao;



/**
 * 类名称: AlibabaSmsReq  
 * 功能描述: 阿里巴巴短信发送请求参数实体 
 * 日期: 2016年12月2日 上午10:01:43 
 * 
 * @author 谢美团
 * @version  
 */
public class AlibabaSmsReq {
	
	
	private String extend;//自定义扩展参数，阿里的响应中将会透传返回该参数。可用作短信发送 的msgId 
	private String smsType ="normal"; //短信类型
	private String smsFreeSignName; //短信签名
	private String smsParamString;//短信模板变量
	private String recNum; //接收号码，多个已都隔开，最多限制200个
	private String smsTemplateCode; //短信模板ID
	private String appKey;  // 应用账号
	private String appSecret;  //应用密码
	
	public String getExtend() {
		return extend;
	}
	public void setExtend(String extend) {
		this.extend = extend;
	}
	public String getSmsType() {
		return smsType;
	}
	public void setSmsType(String smsType) {
		this.smsType = smsType;
	}
	public String getSmsFreeSignName() {
		return smsFreeSignName;
	}
	public void setSmsFreeSignName(String smsFreeSignName) {
		this.smsFreeSignName = smsFreeSignName;
	}
	public String getSmsParamString() {
		return smsParamString;
	}
	public void setSmsParamString(String smsParamString) {
		this.smsParamString = smsParamString;
	}
	public String getRecNum() {
		return recNum;
	}
	public void setRecNum(String recNum) {
		this.recNum = recNum;
	}
	public String getSmsTemplateCode() {
		return smsTemplateCode;
	}
	public void setSmsTemplateCode(String smsTemplateCode) {
		this.smsTemplateCode = smsTemplateCode;
	}
	public String getAppKey() {
		return appKey;
	}
	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}
	public String getAppSecret() {
		return appSecret;
	}
	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}

}