package com.bithealth.cmsCore.healthEducation.enmu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 健教使范围
 * @author 周玉飞
 *
 */
public enum HealthEducationenum {

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

		private HealthEducationenum(Byte code, String name){
			this.code = code;
			this.name = name;
		}
		
		public static HealthEducationenum getEnumByCode(Byte code){
			if(code == null)
				return null;
			for(HealthEducationenum e : HealthEducationenum.values()){
				if(e.getCode().equals(code))
					return e;
			}
			return null;
		}
		
		public static List<Map<String, Object>> allValues() {
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			for(HealthEducationenum role : HealthEducationenum.values()) {
				Map<String, Object> data = new HashMap<String, Object>();
				data.put("code", role.getCode());
				data.put("name", role.getName());
				list.add(data);
			}
			return list;
		}
}
