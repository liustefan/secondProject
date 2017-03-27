package com.bithealth.dataConversionServer.enmu;

public enum MarrayStatusEnmu {
	
	status1("10",  "1", "未婚"),
	status2("20",  "2", "已婚"),
	status3("21",  "3", "初婚"),
	status4("22",  "4", "再婚"),
	status5("23",  "5", "复婚"),
	status6("30",  "6", "丧偶"),
	status7("40",  "7", "离异"),
	status8("90",  "8", "未说明的婚姻状况");
	
	private String index;
	
	private String value;
	
	private String desc;
	
	private MarrayStatusEnmu(String index,String value, String desc) {
		this.index = index;
		this.value = value;
		this.desc = desc;
	}
	
	public static String getValueByIndex(String index) {
		for(MarrayStatusEnmu enmu : MarrayStatusEnmu.values()) {
			if(enmu.getIndex().equals(index)) {
				return enmu.getValue();
			}
		}
		return null;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}
	
	
}
