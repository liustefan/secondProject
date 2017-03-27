package com.bithealth.msgCenterCore.enmu;


/**
 * 类名称: CareAuthorityEnmu  
 * 功能描述: 关注权限枚举类型
 * 日期: 2016年8月27日 下午4:38:25 
 * 
 * @author 谢美团
 * @version  
 */
public enum SmsPriortyEnmu {
	

	PRIORITY_1(1, "紧急"),
	PRIORITY_2(2, "较高"),
	PRIORITY_3(3, "普通"),
	PRIORITY_4(4, "较低"),
	PRIORITY_5(5, "最低");
	
	private int value;
	
	private String desc;
	
	private SmsPriortyEnmu(int value, String desc) {
		this.value = value;
		this.desc = desc;
	}
	
	public static SmsPriortyEnmu getEnmuByVal(int value) {
		for(SmsPriortyEnmu enmu : SmsPriortyEnmu.values()) {
			if(value == enmu.getValue()) {
				return enmu;
			}
		}
		return null;
	}


	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	

}
