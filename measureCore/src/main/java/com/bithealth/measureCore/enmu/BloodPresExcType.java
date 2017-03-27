 
/**
 * @PackageName:      com.bithealth.measureCore.enmu
 * @FileName:     BloodPresExcType.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      陈哲 
 * @version      V1.0  
 * @Createdate:  2016年7月14日 上午11:34:57  
 * 
 */

package com.bithealth.measureCore.enmu;


/**
 * 类名称: BloodPresExcType  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月14日 上午11:34:57 
 * 
 * @author 陈哲
 * @version  
 */
public enum BloodPresExcType {
	NORMAL(0,"正常"), 	 LOWER(1,"偏低"),	HIGHLY(2,"重高"), 	MODERATE(3,"中高"), 
	LIGHT(4,"轻高"),		SYSTOLE(5,"单纯收缩期高血压"),  NORMALHIGH(6,"正常偏高");
	
	int number;
	String name;
	
	private BloodPresExcType(int number, String name){
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

	/**
	 * 
	 * @Title:getNameType 
	 * @Description:通过number获取名称name
	 * @author 陈哲
	 * @param number
	 * @return 
	 * @throws
	 * @retrun String
	 */
	public static String getExcTypeName(int number){
		for(BloodPresExcType type : BloodPresExcType.values()){
			if(number == type.getNumber()){
				return type.getName();
			}
		}
		return null;
	}
}

