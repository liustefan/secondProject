package com.bithealth.memberCore.memberLabel.enmu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 会员标签使用范围
 * @author 周玉飞
 *
 */
public enum LabelUserRange {
	
		//1-全局，2-组织内，3-私有
		GLOBAL((byte)1, "全局"),
		INORG((byte)2, "组织内"),
		OWNED((byte)3, "私有");
		
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

		private LabelUserRange(Byte code, String name){
			this.code = code;
			this.name = name;
		}
		
		public static LabelUserRange getEnumByCode(Byte code){
			if(code == null)
				return null;
			for(LabelUserRange e : LabelUserRange.values()){
				if(e.getCode().equals(code))
					return e;
			}
			return null;
		}
		
		public static List<Map<String, Object>> allValues() {
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			for(LabelUserRange role : LabelUserRange.values()) {
				Map<String, Object> data = new HashMap<String, Object>();
				data.put("code", role.getCode());
				data.put("name", role.getName());
				list.add(data);
			}
			return list;
		}
		
		
}
