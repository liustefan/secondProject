/**
 * @PackageName:      com.bithealth.ucCore.facade.enmu
 * @FileName:     VerifyType.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年12月7日 上午9:25:34  
 * 
 */
package com.bithealth.ucCore.facade.enmu;

/**
 * 类名称: VerifyType  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年12月7日 上午9:25:34 
 * 
 * @author liuhm
 * @version  
 */
public enum VerifyType {
	YES(new Byte("1")),
	NO(new Byte("0"));
	private Byte code;
	private VerifyType(Byte code) {
		this.code = code;
	}
	
	public Byte getCode() {
		return code;
	}
}
