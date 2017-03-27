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
 * 类名称: TaskTypeEnum  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年12月5日 上午11:14:27 
 * 
 * @author baozj
 * @version
 */
public enum TaskTypeEnum {

	//1-健教，2-复诊，3-测量，4-问卷调查，5-高血压随访(公卫)，6-糖尿病随访(公卫)，7-阶段总结
	HEALTHEDUCATION((byte)1, "健教"),
	CPN((byte)2, "复诊"),
	MEASURE((byte)3, "测量"),
	QUESTION((byte)4, "问卷调查"),
	HYPERTENSION((byte)5, "高血压随访(公卫)"),
	DIABETES((byte)6, "糖尿病随访(公卫)"),
	SUMMARY((byte)7, "阶段总结");
	
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

	private TaskTypeEnum(Byte code, String name){
		this.code = code;
		this.name = name;
	}
	
	public static TaskTypeEnum getEnumByCode(Byte code){
		if(code == null)
			return null;
		for(TaskTypeEnum e : TaskTypeEnum.values()){
			if(e.getCode().equals(code))
				return e;
		}
		return null;
	}
	
	public static List<Map<String, Object>> allValues() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for(TaskTypeEnum role : TaskTypeEnum.values()) {
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("code", role.getCode());
			data.put("name", role.getName());
			list.add(data);
		}
		return list;
	}
}
