 

package com.bithealth.taskMgrCore.model;

import java.util.List;


public class UCResult<T> {
	
	private String message;
	private Integer code;
	private List<T> content;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public List<T> getContent() {
		return content;
	}
	public void setContent(List<T> content) {
		this.content = content;
	}

	
	

}

