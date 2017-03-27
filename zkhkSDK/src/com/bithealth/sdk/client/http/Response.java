package com.bithealth.sdk.client.http;


public class Response {
	private String body;
	private String error;
	/**
	 * 200 -正常，500-服务器内部错误，404-网页不存在
	 */
	private int status;
	
	public Response() {
	}
	
	public Response(int status, String body, String error) {
		this.body = body;
		this.error = error;
		this.status = status;
	}
	
	public Response(int status, String body) {
		this(status, body, null);
	}
	
	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}
	
	
	
	
}
