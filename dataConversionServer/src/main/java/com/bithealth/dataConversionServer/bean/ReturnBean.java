package com.bithealth.dataConversionServer.bean;

public class ReturnBean implements java.io.Serializable {

	/**
	* TODO
	*/
	
	private static final long serialVersionUID = 1L;
	
	
	public String code;
	public String message;
	public ReturnContent content;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ReturnContent getContent() {
		return content;
	}
	public void setContent(ReturnContent content) {
		this.content = content;
	}
	
}