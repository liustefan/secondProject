 
/**
 * @PackageName:      com.bithealth.measureCore.enmu
 * @FileName:     BloodSugarTimeType.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      陈哲 
 * @version      V1.0  
 * @Createdate:  2016年7月14日 下午2:02:52  
 * 
 */

package com.bithealth.measureCore.enmu;


/**
 * 类名称: BloodSugarTimeType  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月14日 下午2:02:52 
 * 
 * @author 陈哲
 * @version  
 */
public enum BloodSugarTimeQType {
	OTHER(0,"其他时间"), 		BBF(1,"早餐前"),		  ABF(2,"早餐后2小时"),
	BLF(3,"午餐前"),	  	  	ALF(4,"午餐后2小时"),	  BDF(5,"晚餐前"),
	ADF(6,"晚餐后2小时"),     BSL(7,"睡前"),		  MN(8,"夜间");
	
	int code;
	String name;
	
	private BloodSugarTimeQType(int code, String name){
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
	 * @Title:getTimeQTypeName 
	 * @Description:根据时间点编号code获取时间点名称name
	 * @author 陈哲
	 * @param code
	 * @return 
	 * @throws
	 * @retrun String
	 */
	public static String getTimeQTypeName(int code){
		for(BloodSugarTimeQType type : BloodSugarTimeQType.values()){
			if(type.getCode() == code){
				return type.getName();
			}
		}
		return null;
	}

}

