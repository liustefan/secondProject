/**
 * @PackageName:      com.bithealth.doctorCore.enmu
 * @FileName:     CertiType.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年8月1日 下午12:18:01  
 * 
 */
package com.bithealth.doctorCore.enmu;

/**
 * 类名称: CertiType  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年8月1日 下午12:18:01 
 * 
 * @author liuhm
 * @version  
 */
public enum CertiType {
	IDENTITY(1, "身份证"),
	DRIVE(2, "驾驶证"),
	EXIT_ENTRY(3, "港澳通行证");
	private int code;
	
	private String desc;
	
	private CertiType(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
	
	
	
}
