 
/**
 * @PackageName:      com.bithealth.healthCore.enmu
 * @FileName:     ConclusionTypeEnum.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      名字  * 
 * @version      V1.0  
 * @Createdate:  2016年12月25日 下午3:56:50  
 * 
 */

package com.bithealth.healthCore.enmu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 类名称: ConclusionTypeEnum  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年12月25日 下午3:56:50 
 * 
 * @author baozj
 * @version  
 */
public enum ConclusionTypeEnum {

	//1-继续执行，2-终止方案，3-执行下一阶段方案
	RESUME((byte)1, "继续执行"),
	TERMINATED((byte)2, "终止方案"),
	NEXT((byte)3, "执行下一阶段方案");
	
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

	private ConclusionTypeEnum(Byte code, String name){
		this.code = code;
		this.name = name;
	}
	
	public static ConclusionTypeEnum getEnumByCode(Byte code){
		if(code == null)
			return null;
		for(ConclusionTypeEnum e : ConclusionTypeEnum.values()){
			if(e.getCode().equals(code))
				return e;
		}
		return null;
	}
	
	public static List<Map<String, Object>> allValues() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for(ConclusionTypeEnum role : ConclusionTypeEnum.values()) {
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("code", role.getCode());
			data.put("name", role.getName());
			list.add(data);
		}
		return list;
	}
}

