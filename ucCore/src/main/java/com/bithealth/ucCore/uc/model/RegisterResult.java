/*
 * ReturnResult.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-08-18 Created
 */
package com.bithealth.ucCore.uc.model;

import java.util.List;



/**
 * 类名称: ReturnResult  
 * 功能描述: 注册应答实体类
 * 日期: 2016年8月18日 上午11:46:16 
 * 
 * @author 谢美团
 * @version  
 */
public class RegisterResult {
	
	public String guid; //会员的GUID
	public Integer code;//基本资料注册结果，1-成功，2-失败
	public String msg;//基本资料注册结果说明
	public List <AccountResult> accountlist;//账号注册结果集合
	
	public RegisterResult() {
		
	}
	
	public RegisterResult(String guid, Integer code, String message) {
		this.guid = guid;
		this.code = code;
		this.msg = message;
	}
	
	
	public String getGuid() {
		return guid;
	}
	public void setGuid(String guid) {
		this.guid = guid;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public List<AccountResult> getAccountlist() {
		return accountlist;
	}
	public void setAccountlist(List<AccountResult> accountlist) {
		this.accountlist = accountlist;
	}

}