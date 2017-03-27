package com.bithealth.model;

import com.bithealth.sdk.core.generic.GenericModel;

public class RequetParam extends GenericModel{

	private static final long serialVersionUID = 6806525660089061800L;
	
	private RequestHead head;
	
	private Object content;
	
	private String token;
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public RequestHead getHead() {
		return head;
	}

	public void setHead(RequestHead head) {
		this.head = head;
	}

	public Object getContent() {
		return content;
	}

	public void setContent(Object content) {
		this.content = content;
	}




	

	
}
