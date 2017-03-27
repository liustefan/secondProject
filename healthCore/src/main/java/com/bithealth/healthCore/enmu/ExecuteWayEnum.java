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
public enum ExecuteWayEnum {

	//1-医生电话服务，2-医生现场服务，3-推送消息给会员
	PHONE((byte)1, "医生电话服务"),
	LIVE((byte)2, "医生现场服务"),
	MESSAGE((byte)3, "推送消息给会员");
	
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

	private ExecuteWayEnum(Byte code, String name){
		this.code = code;
		this.name = name;
	}
	
	public static ExecuteWayEnum getEnumByCode(Byte code){
		if(code == null)
			return null;
		for(ExecuteWayEnum e : ExecuteWayEnum.values()){
			if(e.getCode().equals(code))
				return e;
		}
		return null;
	}
	
	public static List<Map<String, Object>> allValues() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for(ExecuteWayEnum role : ExecuteWayEnum.values()) {
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("code", role.getCode());
			data.put("name", role.getName());
			list.add(data);
		}
		return list;
	}
}
