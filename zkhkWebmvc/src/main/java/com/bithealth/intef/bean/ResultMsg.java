/**
 * 
 */
package com.bithealth.intef.bean;

import java.io.Serializable;

/**
 * @author lhm
 *
 */
public class ResultMsg implements Serializable {

	private static final long serialVersionUID = -9169159744372737432L;
	
	public static final int  SUCCESS = 0;
	
	public static final int FAIL = 1;
	
	public static final int SUBMIT = 2; //注册中
	
	private int code;  //0-成功，1-失败
	
	private String message;
	
	public ResultMsg(int code, String message) {
		this.code = code;
		this.message = message;
	}
	
	public ResultMsg() {};

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
