 
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

package com.bithealth.chatCore.enmu;

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
public enum RefStatusEnum {
	
	//[3.0]引用状态：<类型4和5>1-未答、2-已答、3-已审核、4-已撤回
  
	UNFINISHED( 1 , "待答"), 
	COMPLETED( 2 , "已作答"),
	APPROVED( 3 , "已审核"),
	WITHDRAWN ( 4 , "已撤回");
	
	
	
	private byte code;
	private String name;
	
	public byte getCode() {
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

	private RefStatusEnum(int code, String name){
		this.code = (byte) code;
		this.name = name;
	}
	
	public static RefStatusEnum getEnumByCode(int code){
		RefStatusEnum[] enums = RefStatusEnum.values();
		for(RefStatusEnum statusEnum : enums){
			if(statusEnum.code == code){
				return statusEnum;
			}
		}
		return null;
		
		 
	}
	
	public static List<Map<String, Object>> allValues() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for(RefStatusEnum role : RefStatusEnum.values()) {
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("code", role.getCode());
			data.put("name", role.getName());
			list.add(data);
		}
		return list;
	}
}

