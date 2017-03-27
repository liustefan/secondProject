/**
 * @PackageName:      com.bithealth
 * @FileName:     Message.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年7月21日 下午2:45:10  
 * 
 */
package com.bithealth;

import java.io.Serializable;

/**
 * 类名称: Message  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月21日 下午2:45:10 
 * 
 * @author liuhm
 * @version  
 */
public class Message implements Serializable {

	private static final long serialVersionUID = 4183939442660601814L;
	
	private String code;
	private String content;
	private boolean status;
	private Object data;
	public Message(){};
	public Message(boolean status) {
		this.status = status;
	}
	public Message(String content, boolean status) {
		super();
		this.content = content;
		this.status = status;
	}

	public Message(String code, String content, boolean status) {
		super();
		this.code = code;
		this.content = content;
		this.status = status;
	}
	
	public Message(String code, String content, boolean status, Object data) {
		super();
		this.code = code;
		this.content = content;
		this.status = status;
		this.data = data;
	}
	public Message(String content, boolean status, Object data) {
		super();
		this.content = content;
		this.status = status;
		this.data = data;
	}
	public Message(boolean status, Object data) {
		super();
		this.status = status;
		this.data = data;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
}
