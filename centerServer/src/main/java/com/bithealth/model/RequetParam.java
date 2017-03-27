package com.bithealth.model;


import com.bithealth.sdk.core.generic.GenericModel;

public class RequetParam extends GenericModel{

	private static final long serialVersionUID = 6806525660089061800L;
	
	private RequestHead appUserStr;
	
	private Object otherParamStr;
	
	private String token;
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public RequestHead getAppUserStr() {
		return appUserStr;
	}

	public void setAppUserStr(RequestHead appUserStr) {
		this.appUserStr = appUserStr;
	}

	public Object getOtherParamStr() {
		return otherParamStr;
	}

	public void setOtherParamStr(Object otherParamStr) {
		this.otherParamStr = otherParamStr;
	}

	

	
}
