 
/**
 * @PackageName:      com.bithealth.measureCore.enmu
 * @FileName:     BloodSugarTimeQExcType.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      陈哲 
 * @version      V1.0  
 * @Createdate:  2016年7月14日 下午6:03:33  
 * 
 */

package com.bithealth.measureCore.enmu;


/**
 * 类名称: BloodSugarTimeQExcType  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月14日 下午6:03:33 
 * 
 * @author 陈哲
 * @version  
 */
public enum BloodSugarTimeQExcType {
	LOW(0,"偏低"),NORMAL(1,"正常"),HIGH(2,"偏高");
	
	int code;
	String name;
	private BloodSugarTimeQExcType(int code, String name){
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
	 * @Description:通过编码获取中文名称
	 * @author 陈哲
	 * @param code
	 * @return 
	 * @throws
	 * @retrun String
	 */
	public static String getTypeName(int code){
		for(BloodSugarTimeQExcType type : BloodSugarTimeQExcType.values()){
			if(code == type.getCode()){
				return type.getName();
			}
		}
		return null;
	} 
	
}

