 
/**
 * @PackageName:      com.bithealth.measureCore.enmu
 * @FileName:     BloodPresTimePType.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      陈哲 
 * @version      V1.0  
 * @Createdate:  2016年8月8日 下午4:54:43  
 * 
 */

package com.bithealth.measureCore.enmu;


/**
 * 类名称: BloodPresTimePType  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年8月8日 下午4:54:43 
 * 
 * @author 陈哲
 * @version  
 */
public enum BloodPresTimePType {
	OTHER(0, "其他（随机测量）"), AGU(1, "起床后两小时"),BS(2, "睡觉前");
	
	int number;
	String name;
	
	private BloodPresTimePType(int number, String name){
		this.number = number;
		this.name = name;
	}
	
	/**
	 * number.
	 *
	 * @return  the number 
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * number.
	 *
	 * @param   number    the number to set 
	 */
	public void setNumber(int number) {
		this.number = number;
	}

	/**
	 * name.
	 *
	 * @return  the name 
	 */
	public String getName() {
		return name;
	}
	/**
	 * name.
	 *
	 * @param   name    the name to set 
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	public static String getTimeTypeName(int number){
		for(BloodPresTimePType type : BloodPresTimePType.values()){
			if(number == type.getNumber()){
				return type.getName();
			}
		}
		return null;
	}

}

