/**
 * @PackageName:      com.bithealth.memberCore.enmu
 * @FileName:     Occupation.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年7月26日 下午4:29:44  
 * 
 */
package com.bithealth.memberCore.enmu;

import com.bithealth.sdk.common.utils.StringUtil;

/**
 * 类名称: OccupationEnmu  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月26日 下午4:29:44 
 * 
 * @author liuhm
 * @version  
 */
public enum OccupationEnmu {
	OTHER("13", "其他劳动者"),
    NLMYSL("1", "农林牧渔水利业生产人员"),
    SCYS("2", "生产运输设备操作人员及有关人员"),
    ZYJS("3", "专业技术人员"),
    BSRY("4", "办事人员和有关人员"),
    SYFW("5", "商业、服务业人员"),
    GWY("6", "国家机关、党群组织、企事业单位负责人"),
    ZXXS("7", "在校学生"),
    JW("8", "家务"),
    DY("9", "待业"),
    LTX("10", "离退休人员"),
    CHILD("11", "婴幼、学龄前儿童"),
    ARMY("12", "军人");
    
    
    private String value;
    
    private String desc;
    
    private OccupationEnmu(String value, String desc) {
    	this.value = value;
    	this.desc = desc;
    }

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public static String getOccupationValue(String desc) {
		if(StringUtil.isEmpty(desc)) {
			return OTHER.value;
		}
		OccupationEnmu[] occupations = OccupationEnmu.values();
		for(OccupationEnmu enmu : occupations) {
			if(enmu.getDesc().equals(desc.trim())) {
				return enmu.getValue();
			}
		}
		return OTHER.value;
	}
	
	public static String getOccupation(String value) {
		if(StringUtil.isEmpty(value)) {
			return OTHER.desc;
		}
		OccupationEnmu[] occupations = OccupationEnmu.values();
		for(OccupationEnmu enmu : occupations) {
			if(enmu.getValue().equals(value.trim())) {
				return enmu.getDesc();
			}
		}
		return OTHER.desc;
	}
    
}
