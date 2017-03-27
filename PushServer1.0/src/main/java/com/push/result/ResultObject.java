package com.push.result;

import java.io.Serializable;


/**
 * @author xiemt
 *
 */
public class ResultObject implements  Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public int code = 0; 
	
	public String messenger = "success";
	
	public Object result="";



	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessenger() {
		return messenger;
	}

	public void setMessenger(String messenger) {
		this.messenger = messenger;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}
	
	public void setResult(int returnCode,String messenger,Object result) {
		this.result = result;
		this.code = returnCode;
		this.messenger = messenger;
	}
	
	
	
	
}