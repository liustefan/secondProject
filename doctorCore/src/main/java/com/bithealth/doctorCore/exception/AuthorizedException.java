/**
 * @PackageName:      com.bithealth.doctorCore.exception
 * @FileName:     AuthorizedException.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年6月24日 下午2:28:59  
 * 
 */
package com.bithealth.doctorCore.exception;

/**
 * 类名称: AuthorizedException  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年6月24日 下午2:28:59 
 * 
 * @author liuhm
 * @version  
 */
public class AuthorizedException extends Exception {

	private static final long serialVersionUID = -7001824100584833151L;

	public AuthorizedException() {
		super();
	}

	public AuthorizedException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public AuthorizedException(String message, Throwable cause) {
		super(message, cause);
	}

	public AuthorizedException(String message) {
		super(message);
	}

	public AuthorizedException(Throwable cause) {
		super(cause);
	}
	
	
}
