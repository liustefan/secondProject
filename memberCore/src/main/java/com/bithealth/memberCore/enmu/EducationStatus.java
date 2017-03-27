/**
 * @PackageName:      com.bithealth.memberCore.enmu
 * @FileName:     Educa.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年7月26日 下午4:23:46  
 * 
 */
package com.bithealth.memberCore.enmu;

import com.bithealth.sdk.common.utils.StringUtil;

/**
 * 类名称: EducationStatus  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月26日 下午4:23:46 
 * 
 * @author liuhm
 * @version  
 */
public enum EducationStatus {
	//1研究生及以上;2大学本科;3大学专科和专科学校;4中等专业学校;5技工学校;6高中;7初中;8小学;9文盲或半文盲;10学历不详;11无;
	NULL("11", "无"),
	YJS("1", "研究生及以上"),
	BK("2", "大学本科"),
	ZK("3", "大学专科和专科学校"),
	ZDZY("4", "中等专业学校"),
	JGXX("5","技工学校"),
	GZ("6", "高中"),
	CZ("7", "初中"),
	XX("8", "小学"),
	WM("9", "文盲或半文盲"),
	UNKNOW("10", "学历不详");
	
	private String value;
	private String descr;
	private EducationStatus(String value, String descr){
		this.value = value;
		this.descr = descr;
	}
	
	public static String getValue(String descr){
		if(StringUtil.isEmpty(descr)){
			return NULL.value;
		}
		EducationStatus[] statuss = EducationStatus.values();
		for(EducationStatus status : statuss){
			if(status.getDescr().equals(descr)){
				return status.getValue();
			}
		}
		return NULL.getValue();
	}
	
	public static String getEducation(String value){
		if(StringUtil.isEmpty(value)){
			return NULL.descr;
		}
		EducationStatus[] statuss = EducationStatus.values();
		for(EducationStatus status : statuss){
			if(status.getValue().equals(value)){
				return status.getDescr();
			}
		}
		return NULL.getDescr();
	}

	
	public String getValue() {
		return value;
	}


	public void setValue(String value) {
		this.value = value;
	}


	public String getDescr() {
		return descr;
	}


	public void setDescr(String descr) {
		this.descr = descr;
	}

}
