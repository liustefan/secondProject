package com.bithealth.centCore.sms.enmu;


/**
 * 类名称: CareAuthorityEnmu  
 * 功能描述: 关注权限枚举类型
 * 日期: 2016年8月27日 下午4:38:25 
 * 
 * @author 谢美团
 * @version  
 */
public enum SmsPriortyEnmu {
	

	PRIORITY_1("1", "优先级-紧急"),
	PRIORITY_2("2", "优先级-较高"),
	PRIORITY_3("3", "优先级-扑通"),
	PRIORITY_4("4", "优先级-较低"),
	PRIORITY_5("5", "优先级-最低");
	
	private String value;
	
	private String desc;
	
	private SmsPriortyEnmu(String value, String desc) {
		this.value = value;
		this.desc = desc;
	}
	
	public SmsPriortyEnmu getEnmuByVal(int value) {
		for(SmsPriortyEnmu enmu : SmsPriortyEnmu.values()) {
			if(enmu.getValue().equals(value)) {
				return enmu;
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
	

}
