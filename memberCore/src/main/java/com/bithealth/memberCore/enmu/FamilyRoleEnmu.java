package com.bithealth.memberCore.enmu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.annotation.JSONCreator;
import com.alibaba.fastjson.annotation.JSONField;

public enum FamilyRoleEnmu {
	Self(0, ""),
	Father(1, "爸爸"),
	Mather(2, "妈妈"),
	GrandFather(3, "爷爷"),
	GrandMother(4, "奶奶"),
	Son(5, "儿子"),
	Daughter(6, "女儿"),
//	Husband(7, "丈夫"),
//	Wife(8, "妻子"),
	Other(7, "其他");
    private Integer role;
    private String relation;
    private FamilyRoleEnmu(Integer role, String relation) {
    	this.role = role;
    	this.relation = relation;
    }
    @JSONCreator
	public Integer getRole() {
		return role;
	}
	public void setRole(Integer role) {
		this.role = role;
	}
	public String getRelation() {
		return relation;
	}
	@JSONField
	public void setRelation(String relation) {
		this.relation = relation;
	}
	
	public static List<Map<String, Object>> allValues() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for(FamilyRoleEnmu role : FamilyRoleEnmu.values()) {
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("role", role.getRole());
			data.put("relation", role.getRelation());
			list.add(data);
		}
		return list;
	}
	
	public static String getRoleName(int roleId){
		for(FamilyRoleEnmu role : FamilyRoleEnmu.values()) {
			if(role.role.intValue() == roleId) {
				return role.relation;
			}
		}
		return "";
	}
}
