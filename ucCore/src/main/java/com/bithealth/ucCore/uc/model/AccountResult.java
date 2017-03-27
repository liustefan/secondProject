/*
 * ReturnResult.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-08-18 Created
 */
package com.bithealth.ucCore.uc.model;



/**
 * 类名称: ReturnResult  
 * 功能描述: 账号注册结果
 * 日期: 2016年8月18日 上午11:46:16 
 * 
 * @author 谢美团
 * @version  
 */
public class AccountResult {
	
	public Integer code;//账号注册结果，1-成功，2-失败
	public String msg;//账号注册结果说明
	public String account;//成功注册的账号
	public Integer accountType;//账号类型：1-手机号码；2-邮件；3-身份证，4-其他
	
	public AccountResult(int code, String account, Integer type) {
		this.code = code;
		this.account = account;
		this.accountType = type;
	}
	public AccountResult() {
		
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
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public Integer getAccountType() {
		return accountType;
	}
	public void setAccountType(Integer accountType) {
		this.accountType = accountType;
	}
				
}