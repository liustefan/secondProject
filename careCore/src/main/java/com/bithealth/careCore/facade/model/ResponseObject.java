/*
 * ReturnResult.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-08-18 Created
 */
package com.bithealth.careCore.facade.model;

/**
 * 类名称: ReturnObject  
 * 功能描述: appServer应答实体类 
 * 日期: 2016年8月30日 上午9:41:39 
 * 
 * @author 谢美团
 * @version  
 */
public class ResponseObject {
	
	
	public String message = "success";
	
	public int statusCode = 0;
	
	public Object data;
	

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	
	
	
	
}