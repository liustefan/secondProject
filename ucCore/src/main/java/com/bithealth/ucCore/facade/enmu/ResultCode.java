/**
 * @PackageName:      com.bithealth.ucCore.facade.enmu
 * @FileName:     ResultCode.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年12月8日 下午1:36:34  
 * 
 */
package com.bithealth.ucCore.facade.enmu;

/**
 * 类名称: ResultCode  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年12月8日 下午1:36:34 
 * 
 * @author liuhm
 * @version  
 */
public enum ResultCode {
	Other_ERROR(1000, "其他"),
	User_Unknow(101, "会员不存在"),
	Server_internal_Error(201, "服务内部错误"),
	Parameter_Error(301, "参数错误");
	
	public int code;
	
	public String desc;
	
	private ResultCode(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}

}
