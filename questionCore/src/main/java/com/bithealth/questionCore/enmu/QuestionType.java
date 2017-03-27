 
/**
 * @PackageName:      com.bithealth.questionCore.enmu
 * @FileName:     QuestionType.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      名字  * 
 * @version      V1.0  
 * @Createdate:  2016年8月3日 上午11:03:55  
 * 
 */

package com.bithealth.questionCore.enmu;


/**
 * 类名称: QuestionType  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年8月3日 上午11:03:55 
 * 
 * @author baozj
 * @version  
 */
public enum QuestionType {

	ONE(1, "老年人生活自理能力评估问卷"),
	TWO(2, "中医体质辨识问卷");
	
	private Integer code;
	private String name;
	
	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private QuestionType(Integer code, String name){
		this.code = code;
		this.name = name;
	}
}

