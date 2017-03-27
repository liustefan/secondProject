/**
 * @PackageName:      com.bithealth.memberCore.uc.bean
 * @FileName:     UCRetBase.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年12月12日 上午10:27:39  
 * 
 */
package com.bithealth.memberCore.uc.bean;

import java.io.Serializable;

/**
 * 类名称: UCRetBase  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年12月12日 上午10:27:39 
 * 
 * @author liuhm
 * @version  
 */
public class UCRetBase implements Serializable {

	private static final long serialVersionUID = 1992369501670401720L;
	
	/**
	 * 0-成功
	 */
	private int code;
	
	private String message;
	
	public UCRetBase(){
		
	}
	
	public UCRetBase(int code, String message) {
		this.code = code;
		this.message = message;
	}

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
