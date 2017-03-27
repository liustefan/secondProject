/**
 * @PackageName:      com.bithealth.memberCore.enmu
 * @FileName:     RelationEnmu.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年7月27日 下午3:41:48  
 * 
 */
package com.bithealth.memberCore.enmu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 类名称: RelationEnmu  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月27日 下午3:41:48 
 * 
 * @author liuhm
 * @version  
 */
public enum RelationEnmu {
	BROTHER_SISTER(new Integer(4).byteValue(), "兄弟姐妹"),
	CHILDREN(new Integer(3).byteValue(), "子女"),
	MOTHER(new Integer(2).byteValue(), "母亲"),
	FATHER(new Integer(1).byteValue(), "父亲");
	
	private String relation;
	
	private Byte code;
	
	private RelationEnmu(Byte code, String relation) {
		this.relation = relation;
		this.code = code;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public Byte getCode() {
		return code;
	}

	public void setCode(Byte code) {
		this.code = code;
	}
	
	public static List<Map<String, Object>> relations() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for(RelationEnmu item : RelationEnmu.values()) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("code", item.code);
			map.put("relation", item.relation);
			list.add(map);
		}
		
		return list;
	}
	
}
