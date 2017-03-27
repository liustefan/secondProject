package com.bithealth.model;

import com.bithealth.sdk.core.generic.GenericModel;

public class AccessParam extends GenericModel{

	/* */
	private static final long serialVersionUID = 6806525660089061800L;
	
	/* 用户对象  */
	private String appUser;
	
	/* 其他请求参数   */
	private String otherParam;

	public String getAppUser() {
		return appUser;
	}

	public void setAppUser(String appUser) {
		this.appUser = appUser;
	}

	public String getOtherParam() {
		return otherParam;
	}

	public void setOtherParam(String otherParam) {
		this.otherParam = otherParam;
	}

	
}
