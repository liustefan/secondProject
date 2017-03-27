/**
 * @PackageName:      com.bithealth.doctorCore.exception
 * @FileName:     LoginException.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年6月23日 下午3:34:56  
 * 
 */
package com.bithealth.sdk.client.http;

/**
 * 类名称: LoginException  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年6月23日 下午3:34:56 
 * 
 * @author liuhm
 * @version  
 */
public class ResponseException extends Exception {
 
	private String body;
	private String error;
	private int status;
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

	public ResponseException() {
		super();
	}

	public ResponseException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ResponseException(String message, Throwable cause) {
		super(message, cause);
	}

	public ResponseException(Throwable cause) {
		super(cause);
	}

}
