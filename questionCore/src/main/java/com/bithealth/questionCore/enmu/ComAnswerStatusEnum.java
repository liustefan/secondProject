 
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

import org.apache.commons.lang.StringUtils;


/**
 * 类名称: SingleQuestionStatusEnum  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月13日 下午5:33:40 
 * 
 * @author baozj
 * @version  
 */
public enum ComAnswerStatusEnum {

	UNFINISHED("0", "未作答"),
	STAGING("3", "作答中"),
	COMPLETED("1", "已作答"),
	AUDITING("4", "审核中"),
	APPROVED("2", "已审核");
	
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

	private ComAnswerStatusEnum(String code, String name){
		this.code = code;
		this.name = name;
	}
	
	public static ComAnswerStatusEnum getEnumByCode(String code){
		if(StringUtils.isEmpty(code))
			return null;
		for(ComAnswerStatusEnum e : ComAnswerStatusEnum.values()){
			if(e.getCode().equals(code))
				return e;
		}
		return null;
	}
}

