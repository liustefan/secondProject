 
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
 * 类名称: BloodSugarResultTips 
 * 功能描述: 血糖测量结果异常提示语  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月14日 下午6:03:33 
 * 
 * @author liuxiaoqin
 * @version  
 */
public enum BloodSugarResultTips {
	
	//分析结果值(1:血糖偏低;2:血糖偏高;0：正常)
	
	NORMAL(0,"您的血糖值在控制目标范围之内！请继续保持！祝您健康！"),
	LOW(1,"您此次测量提示血糖偏低，建议您保持休息状态，并适当进食。如反复出现类似情况，请及时去医院就诊。平时注意切勿空腹运动、适当控制运动量、加强血糖监测，外出时随身携带含糖食物、预防跌倒。"),
	HIGH(2,"您此次测量提示血糖偏高，建议您根据血糖测量时间点，加强血糖监测。如血糖持续偏高或波动较大，请及时去医院就诊。平时注意低糖饮食、戒烟限酒、加强运动、控制体重、保持心情愉快。");
	
	int code;
	String name;
	
	private BloodSugarResultTips(int code, String name){
		this.code = code;
		this.name = name;
	}
	
	public int getCode() {
		return code;
	}
	
	public void setCode(int code) {
		this.code = code;
	}
	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 
	 * @Title: getTipsName 
	 * @Description:通过编码获取中文名称
	 * @author liuxiaoqin
	 * @param code
	 * @return 
	 * @throws
	 * @retrun String
	 */
	public static String getTipsName(int code){
		for(BloodSugarResultTips type : BloodSugarResultTips.values()){
			if(code == type.getCode()){
				return type.getName();
			}
		}
		return null;
	} 
	
}

