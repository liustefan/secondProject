package com.bithealth.memberCore.memberLabel.enmu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum LabelStatus {
		//1-新增，2-启用，3-禁用
		ADDED((byte)1, "新增"),
		EFFECT((byte)2, "启用"),
		INVALIDATE((byte)3, "禁用");
		
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

		private LabelStatus(Byte code, String name){
			this.code = code;
			this.name = name;
		}
		
		public static LabelStatus getEnumByCode(Byte code){
			if(code == null)
				return null;
			for(LabelStatus e : LabelStatus.values()){
				if(e.getCode().equals(code))
					return e;
			}
			return null;
		}
		
		public static List<Map<String, Object>> allValues() {
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			for(LabelStatus role : LabelStatus.values()) {
				Map<String, Object> data = new HashMap<String, Object>();
				data.put("code", role.getCode());
				data.put("name", role.getName());
				list.add(data);
			}
			return list;
		}

}
