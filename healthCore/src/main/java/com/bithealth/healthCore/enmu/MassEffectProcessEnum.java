 
/**
 * @PackageName:      com.bithealth.healthCore.enmu
 * @FileName:     MassEffectProcessEnum.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      名字  * 
 * @version      V1.0  
 * @Createdate:  2016年12月14日 上午10:49:52  
 * 
 */

package com.bithealth.healthCore.enmu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 类名称: MassEffectProcessEnum  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年12月14日 上午10:49:52 
 * 
 * @author baozj
 * @version  
 */
public enum MassEffectProcessEnum {
	
	//1-未触发，2-生成中，3-完成，4-失败
	NOTRIGGER((byte)1, "未触发"),
	GENERATING((byte)2, "生成中"),
	FINISH((byte)3, "已生成"),
	FAIL((byte)4, "生成失败");
	
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

	private MassEffectProcessEnum(Byte code, String name){
		this.code = code;
		this.name = name;
	}
	
	public static MassEffectProcessEnum getEnumByCode(Byte code){
		if(code == null)
			return null;
		for(MassEffectProcessEnum e : MassEffectProcessEnum.values()){
			if(e.getCode().equals(code))
				return e;
		}
		return null;
	}
	
	public static List<Map<String, Object>> allValues() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for(MassEffectProcessEnum role : MassEffectProcessEnum.values()) {
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("code", role.getCode());
			data.put("name", role.getName());
			list.add(data);
		}
		return list;
	}
}

