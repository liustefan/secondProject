 
/**
 * @PackageName:      com.bithealth.questionCore.enmu
 * @FileName:     SingleQuestionStatusEnum.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      名字  * 
 * @version      V1.0  
 * @Createdate:  2016年7月13日 下午5:33:40  
 * 
 */

package com.bithealth.healthCore.enmu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



/**
 * 类名称: SingleQuestionStatusEnum  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月13日 下午5:33:40 
 * 
 * @author baozj
 * @version  
 */
public enum UseRangeEnum {
	
	//1-全局，2-组织内，3-私有
	GLOBAL((byte)1, "全局"),
	INORG((byte)2, "组织内"),
	OWNED((byte)3, "私人");
	
	private Byte code;
	private String name;
	
	public Byte getCode() {
		return code;
	}

	public void setCode(Byte code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private UseRangeEnum(Byte code, String name){
		this.code = code;
		this.name = name;
	}
	
	public static UseRangeEnum getEnumByCode(Byte code){
		if(code == null)
			return null;
		for(UseRangeEnum e : UseRangeEnum.values()){
			if(e.getCode().equals(code))
				return e;
		}
		return null;
	}
	
	public static List<Map<String, Object>> allValues() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for(UseRangeEnum role : UseRangeEnum.values()) {
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("code", role.getCode());
			data.put("name", role.getName());
			list.add(data);
		}
		return list;
	}
}

