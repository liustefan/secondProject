package com.bithealth.memberCore.uc.bean;

import java.io.Serializable;
import java.util.List;

public class MemberResponse implements Serializable {

	private static final long serialVersionUID = 6614861715310877390L;
	
	private String guid ;
	
	//1成功，2失败
	private int code;
	
	private String msg;
	
	private List<Account> accountList;

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public List<Account> getAccountList() {
		return accountList;
	}

	public void setAccountList(List<Account> accountList) {
		this.accountList = accountList;
	}

	@Override
	public String toString() {
		return "MemberResponse [guid=" + guid + ", code=" + code + ", msg="
				+ msg + ", accountList=" + accountList + "]";
	}
	
	
}
