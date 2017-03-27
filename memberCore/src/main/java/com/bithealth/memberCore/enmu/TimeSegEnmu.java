/**
 * @PackageName:      com.bithealth.memberCore.enmu
 * @FileName:     TimeSegEnmu.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年7月26日 下午6:02:59  
 * 
 */
package com.bithealth.memberCore.enmu;

/**
 * 类名称: TimeSegEnmu  
 * 功能描述: 时段定义.  
 * 日期: 2016年7月26日 下午6:02:59 
 * 
 * @author liuhm
 * @version  
 */
public enum TimeSegEnmu {
	NULL(-1, ""),
	ZERO(0, "5:30-7:30"),
	ONE(1, "7:30-9:30"),
	TWO(2, "9:30-11:30"),
	THREE(3, "11:30-13:30"),
	FOUR(4, "13:30-15:30"),
	FIVE(5, "15:30-17:30"),
	SIX(6, "17:30-19:30"),
	SEVEN(7, "19:30-21:30"),
	EIGHT(8, "21:30-23:30");
	
	private int value;
	
	private String segValue;
	
	private TimeSegEnmu(int value, String seg) {
		this.segValue = seg;
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getSegValue() {
		return segValue;
	}

	public void setSegValue(String segValue) {
		this.segValue = segValue;
	}
	

}
