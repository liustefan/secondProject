/**
 * 
 */
package com.bithealth.healthCore.enmu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * 类名称: PlanTimeTypeEnum  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年12月5日 上午11:14:41 
 * 
 * @author baozj
 * @version
 */
public enum PlanTimeTypeEnum {

	//1-天，2-周，3-月，4-年
	DAY((byte)1, "天"),
	WEEK((byte)2, "周"),
	MONTH((byte)3, "月"),
	YEAR((byte)4, "年");
	
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

	private PlanTimeTypeEnum(Byte code, String name){
		this.code = code;
		this.name = name;
	}
	
	public static PlanTimeTypeEnum getEnumByCode(Byte code){
		if(code == null)
			return null;
		for(PlanTimeTypeEnum e : PlanTimeTypeEnum.values()){
			if(e.getCode().equals(code))
				return e;
		}
		return null;
	}
	
	public static List<Map<String, Object>> allValues() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for(PlanTimeTypeEnum role : PlanTimeTypeEnum.values()) {
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("code", role.getCode());
			data.put("name", role.getName());
			list.add(data);
		}
		return list;
	}
}
