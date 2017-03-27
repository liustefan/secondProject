 
/**
 * @PackageName:      com.bithealth.questionCore.enmu
 * @FileName:     SingleQuestionStatusEnum.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      名字  * 
 * @version      V1.0  
 * @Createdate:  2016年7月13日 下午5:33:40  
 * 
 */

package com.bithealth.questionCore.enmu;


/**
 * 类名称: SingleQuestionStatusEnum  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月13日 下午5:33:40 
 * 
 * @author baozj
 * @version  
 */
public enum SingleQuestionStatusEnum {

	DELETED("N", "已删除"),
	DRAFT("D", "草稿"),
	VALID("T", "已生效");
	
	private String code;
	private String name;
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private SingleQuestionStatusEnum(String code, String name){
		this.code = code;
		this.name = name;
	}
}

