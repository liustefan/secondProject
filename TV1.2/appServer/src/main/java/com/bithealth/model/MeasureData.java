package com.bithealth.model;

import com.bithealth.sdk.core.generic.GenericModel;

public class MeasureData extends GenericModel{

	/** */
	private static final long serialVersionUID = -3770793898852252723L;
	
	/* 测量类型 ：1血压;2血糖;3三合一;4心电mini;5全部类型  */
    private int measType;
	
    /* 测量时间：2016-08-08 08:08:08  */
	private String measureTime;
	
	/* 是否有异:0 正常 ;1 异常  */
	private int isAbnormal = 0;
	
	/* 测量数据 */
	private Object data;

	public int getMeasType() {
		return measType;
	}

	public void setMeasType(int measType) {
		this.measType = measType;
	}

	public String getMeasureTime() {
		return measureTime;
	}

	public void setMeasureTime(String measureTime) {
		this.measureTime = measureTime;
	}

	public int getIsAbnormal() {
		return isAbnormal;
	}

	public void setIsAbnormal(int isAbnormal) {
		this.isAbnormal = isAbnormal;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	

}
