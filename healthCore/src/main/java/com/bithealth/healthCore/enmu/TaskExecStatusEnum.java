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
 * 类名称: ExecuteWayEnum  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年12月5日 上午11:14:45 
 * 
 * @author baozj
 * @version
 */
public enum TaskExecStatusEnum {

	//1-待执行，2-已执行，3-已终止
	EXECUTORY((byte)1, "待执行"),
	EXECUTED((byte)2, "已执行"),
	TERMINATED((byte)3, "已终止");
	
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

	private TaskExecStatusEnum(Byte code, String name){
		this.code = code;
		this.name = name;
	}
	
	public static TaskExecStatusEnum getEnumByCode(Byte code){
		if(code == null)
			return null;
		for(TaskExecStatusEnum e : TaskExecStatusEnum.values()){
			if(e.getCode().equals(code))
				return e;
		}
		return null;
	}
	
	public static List<Map<String, Object>> allValues() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for(TaskExecStatusEnum role : TaskExecStatusEnum.values()) {
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("code", role.getCode());
			data.put("name", role.getName());
			list.add(data);
		}
		return list;
	}
}
