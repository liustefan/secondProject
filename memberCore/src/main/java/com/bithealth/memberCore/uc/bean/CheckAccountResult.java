/**
 * @PackageName:      com.bithealth.memberCore.uc.bean
 * @FileName:     CheckAccountResult.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年12月23日 下午4:12:09  
 * 
 */
package com.bithealth.memberCore.uc.bean;

/**
 * 类名称: CheckAccountResult  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年12月23日 下午4:12:09 
 * 
 * @author liuhm
 * @version  
 */
public class CheckAccountResult extends UCRetBase {

	private static final long serialVersionUID = -6274253868540666045L;
	
	private AppServer content;

	public AppServer getContent() {
		return content;
	}

	public void setContent(AppServer content) {
		this.content = content;
	}
	
}
