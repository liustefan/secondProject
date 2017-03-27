 
/**
 * @PackageName:      com.bithealth.measureCore.enmu
 * @FileName:     BloodSugarTimePType.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      陈哲 
 * @version      V1.0  
 * @Createdate:  2016年7月14日 下午6:09:07  
 * 
 */

package com.bithealth.measureCore.enmu;


/**
 * 类名称: BloodSugarTimePType  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月14日 下午6:09:07 
 * 
 * @author 陈哲
 * @version  
 */
public enum BloodSugarTimePType {
	MO(0,"8点前"),	AN(1,"8-12点"),	AF(2,"12-18点"),	EV(3,"18点以后");
	
	int code;
	String name;
	
	private BloodSugarTimePType(int code, String name){
		this.code = code;
		this.name = name;
	}

	/**
	 * code.
	 *
	 * @return  the code 
	 */
	public int getCode() {
		return code;
	}

	/**
	 * code.
	 *
	 * @param   code    the code to set 
	 */
	public void setCode(int code) {
		this.code = code;
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
	 * @Title:getTypeName 
	 * @Description:通过编码查找中文名称 
	 * @author 陈哲
	 * @param code
	 * @return 
	 * @throws
	 * @retrun String
	 */
	public static String getTypeName(int code){
		for(BloodSugarTimePType type : BloodSugarTimePType.values()){
			if(code == type.getCode()){
				return type.getName();
			}
		}
		return null;
	}
}

