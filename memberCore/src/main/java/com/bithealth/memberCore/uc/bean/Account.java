package com.bithealth.memberCore.uc.bean;

import java.io.Serializable;


public class Account implements Serializable {

	private static final long serialVersionUID = 3116583765084006899L;
	
	private String account;
	
	private String accountType;
	
	public Account(String accountType, String account) {
		this.account = account;
		this.accountType = accountType;
	}
	
	public Account() {
		
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	@Override
	public String toString() {
		return "Account [account=" + account + ", accountType=" + accountType
				+ "]";
	}

}
