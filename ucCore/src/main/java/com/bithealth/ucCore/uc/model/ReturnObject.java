/*
 * ReturnResult.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-08-18 Created
 */
package com.bithealth.ucCore.uc.model;



/**
 * 类名称: RegisterResult  
 * 功能描述: 注册应答实体类
 * 日期: 2016年8月18日 上午11:46:16 
 * 
 * @author 谢美团
 * @version  
 */
public class ReturnObject {
	
	
	public String message = "success";
	
	public int code = 0;
	
	public Object content;
	
	public ReturnObject() {
		
	}
	
	public ReturnObject(int code, String message) {
		this.code = code;
		this.message = message;
	}
	
	public ReturnObject(int code, String message, Object content) {
		this(code, message);
		this.content = content;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Object getContent() {
		return content;
	}

	public void setContent(Object content) {
		this.content = content;
	}
	
	
}