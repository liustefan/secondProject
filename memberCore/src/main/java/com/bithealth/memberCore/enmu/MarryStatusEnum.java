/**
 * @PackageName:      com.bithealth.memberCore.enmu
 * @FileName:     MarrayStatus.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年7月26日 下午4:16:40  
 * 
 */
package com.bithealth.memberCore.enmu;

import com.bithealth.sdk.common.utils.StringUtil;

/**
 * 类名称: MarryStatusEnum  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月26日 下午4:16:40 
 * 
 * @author liuhm
 * @version  
 */
public enum MarryStatusEnum {
	UNKNOW("8", "未说明的婚姻状况"),
	WH("1", "未婚"),
	YH("2", "已婚"),
	CH("3", "初婚"),
	ZH("4", "再婚"),
	FH("5", "复婚"),
	SO("6", "丧偶"),
	LY("7", "离异");
	private String descr;
	private String val;
	
	private MarryStatusEnum(String val,String descr){
		this.descr = descr;
		this.val = val;
	}
	
	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public String getVal() {
		return val;
	}

	public void setVal(String val) {
		this.val = val;
	}

	public static String getDesc(String value){
		if(StringUtil.isEmpty(value)){
			return UNKNOW.descr;
		}
		MarryStatusEnum[] enums = MarryStatusEnum.values();
		for(MarryStatusEnum status : enums){
			if(status.getVal().equals(value)){
				return status.getDescr();
			}
		}
		return UNKNOW.descr;
	}
	
	public static String getValue(String descr){
		if(StringUtil.isEmpty(descr)) {
			return UNKNOW.val;
		}
		MarryStatusEnum[] enums = MarryStatusEnum.values();
		for(MarryStatusEnum status : enums){
			if(status.getDescr().equals(descr)){
				return status.getVal();
			}
		}
		return UNKNOW.getVal();
	}

}
