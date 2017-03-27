package com.bithealth.dataConversionServer.enmu;

public enum EducationStatusEnmu {
	
	status1("10",  "1", "研究生及以上"),
	status2("20",  "2", "大学本科"),
	status3("30",  "3", "大学专科和专科学校"),
	status4("40",  "4","中等专业学校"),
	status5("50",  "5","技工学校"),
	status6("60",  "6","高中"),
	status7("70",  "7","初中"),
	status8("80",  "8","小学"),
	status9("90",  "9","文盲或半文盲"),
	status10("99", "10","学历不详"),
	status11("100","11","无");
	
	private String index;
	
	private String value;
	
	private String desc;
	
	private EducationStatusEnmu(String index,String value, String desc) {
		this.index = index;
		this.value = value;
		this.desc = desc;
	}
	
	public static String getValueByIndex(String index) {
		for(EducationStatusEnmu enmu : EducationStatusEnmu.values()) {
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
