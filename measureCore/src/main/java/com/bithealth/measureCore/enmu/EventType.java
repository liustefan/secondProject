 
/**
 * @PackageName:      com.bithealth.measureCore.enmu
 * @FileName:     PulseType.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      陈哲 
 * @version      V1.0  
 * @Createdate:  2016年7月14日 下午1:38:33  
 * 
 */

package com.bithealth.measureCore.enmu;


/**
 * 类名称: EventType  
 * 功能描述: 测量类型枚举类 
 * 日期: 2016年10月20日 上午11:31:21 
 * 
 * @author 谢美团
 * @version  
 */
public enum EventType {
	BLOOD_PRESSURE("1","血压"),		
	BLOOD_SUGAR("2","血糖"),
	SAN_HE_YI("3","三合一"),		
	DONG_TAI_XIN_DIAN("4","动态心电");

	private String code;
	String name;

	private EventType(String code, String name) {
		this.code = code;
		this.name = name;
	}

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

	public static String getPulseTypeName(int code){
		for(EventType type : EventType.values()){
			if(type.getCode().equals(code)){
				return type.getName();
			}
		}
		return null;
	}
	
}

