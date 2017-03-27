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
package com.bithealth.memberCore.exception;


/**
 * 类名称: LoginException  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年6月23日 下午3:34:56 
 * 
 * @author liuhm
 * @version  
 */
public class LoginException extends Exception {

	private static final long serialVersionUID = -2736273523701459136L;
	
	/**
	 * 账号错误
	 */
	public static final String ERROR_NAME="000000"; 
	
	/**
	 * 密码有误
	 */
	public static final String ERROR_PWD = "100000";
	
	/**
	 * 用户名或者密码为空
	 */
	public static final String ERROR_EMPTY = "200000";  
	
	/**
	 * 用户被禁用
	 */
	public static final String ERROR_STATUS = "300000";
	
	/**
	 * 超过失败次数
	 */
	public static final String OVER_FAIL_COUNT = "400000";
	
	/**
	 * 账号注销
	 */
	public static final String USER_LOGOUT = "500000";
	
	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public LoginException(String code) {
		super();
		this.code = code;
	}

	public LoginException() {
		super();
	}

	public LoginException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public LoginException(String message, Throwable cause) {
		super(message, cause);
	}

	public LoginException(Throwable cause) {
		super(cause);
	}
}
