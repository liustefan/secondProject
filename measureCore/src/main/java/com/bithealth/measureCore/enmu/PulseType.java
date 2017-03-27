 
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
 * 类名称: PulseType  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月14日 下午1:38:33 
 * 
 * @author 陈哲
 * @version  
 */
public enum PulseType {
	PR("PR","脉搏率"),		K("K","波形特征量"),		AC("AC","血管顺应度"),			SI("SI","血管硬化指数"),
	V("V","血液粘度"),		TPR("TPR","外周阻力"),	CI("CI","心指数"),			SPI("SPI","心搏指数"),
	PM("PM","平均动脉压"),		CO("CO","平均每分射血量"),	SV("SV","心脏每次射血量"),		SPO("SPO","血氧饱和度");

	String code;
	String name;
	
	private PulseType(String code, String name){
		this.code = code;
		this.name = name;
	}

	/**
	 * code.
	 *
	 * @return  the code 
	 */
	public String getCode() {
		return code;
	}

	/**
	 * code.
	 *
	 * @param   code    the code to set 
	 */
	public void setCode(String code) {
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
	
	public static String getPulseTypeName(String code){
		for(PulseType type : PulseType.values()){
			if(type.getCode().equals(code)){
				return type.getName();
			}
		}
		return null;
	}
	
}

