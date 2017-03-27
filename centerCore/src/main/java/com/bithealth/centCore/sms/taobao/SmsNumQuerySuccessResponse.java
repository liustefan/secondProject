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
public class SmsNumQuerySuccessResponse {
	
	private int current_page;
	private int page_size;
	private int total_count;
	private int total_page;
	private SmsNumQueryDetail values;

	public SmsNumQueryDetail getValues() {
		return values;
	}
	public void setValues(SmsNumQueryDetail values) {
		this.values = values;
	}
	private String request_id;
	
	public String getRequest_id() {
		return request_id;
	}
	public void setRequest_id(String request_id) {
		this.request_id = request_id;
	}
	public int getCurrent_page() {
		return current_page;
	}
	public void setCurrent_page(int current_page) {
		this.current_page = current_page;
	}
	public int getPage_size() {
		return page_size;
	}
	public void setPage_size(int page_size) {
		this.page_size = page_size;
	}
	public int getTotal_count() {
		return total_count;
	}
	public void setTotal_count(int total_count) {
		this.total_count = total_count;
	}
	public int getTotal_page() {
		return total_page;
	}
	public void setTotal_page(int total_page) {
		this.total_page = total_page;
	}


}