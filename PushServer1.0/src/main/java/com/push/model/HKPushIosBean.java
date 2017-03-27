package com.push.model;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;


/**
 * @author xiemt
 *
 */
public class HKPushIosBean {
	
	private JSONObject payload;
	
	private String apnsToken;
	
	private List<?> apnsTokens = new ArrayList();

	public JSONObject getPayload() {
		return payload;
	}

	public void setPayload(JSONObject payload) {
		this.payload = payload;
	}

	public String getApnsToken() {
		return apnsToken;
	}

	public void setApnsToken(String apnsToken) {
		this.apnsToken = apnsToken;
	}

	public List getApnsTokens() {
		return apnsTokens;
	}

	public void setApnsTokens(List apnsTokens) {
		this.apnsTokens = apnsTokens;
	}
	
	
	
}