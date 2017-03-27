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
 * 功能描述: 阿里巴巴短信查询返回实体 
 * 日期: 2016年12月2日 上午10:01:43 
 * 
 * @author 谢美团
 * @version  
 */
public class SmsNumQueryResult {
	

	private String extend;
	private String rec_num;
	private String result_code;
	private String sms_code;
	private String sms_content;
	private String sms_receiver_time;
	private String sms_send_time;
	private int sms_status;
	
	public String getExtend() {
		return extend;
	}
	public void setExtend(String extend) {
		this.extend = extend;
	}
	public String getRec_num() {
		return rec_num;
	}
	public void setRec_num(String rec_num) {
		this.rec_num = rec_num;
	}
	public String getResult_code() {
		return result_code;
	}
	public void setResult_code(String result_code) {
		this.result_code = result_code;
	}
	public String getSms_code() {
		return sms_code;
	}
	public void setSms_code(String sms_code) {
		this.sms_code = sms_code;
	}
	public String getSms_content() {
		return sms_content;
	}
	public void setSms_content(String sms_content) {
		this.sms_content = sms_content;
	}
	public String getSms_receiver_time() {
		return sms_receiver_time;
	}
	public void setSms_receiver_time(String sms_receiver_time) {
		this.sms_receiver_time = sms_receiver_time;
	}
	public String getSms_send_time() {
		return sms_send_time;
	}
	public void setSms_send_time(String sms_send_time) {
		this.sms_send_time = sms_send_time;
	}
	public int getSms_status() {
		return sms_status;
	}
	public void setSms_status(int sms_status) {
		this.sms_status = sms_status;
	}
	
	

}