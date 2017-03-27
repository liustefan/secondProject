package com.bithealth.centCore.care.enmu;


/**
 * 类名称: CareAuthorityEnmu  
 * 功能描述: 关注发送枚举类型
 * 日期: 2016年8月27日 下午4:38:25 
 * 
 * @author 谢美团
 * @version  
 */
public enum CareSendTypeEnmu {
	
	TYPE_DOCTOR(1, "医生"),
	TYPE_MEMBER(2, "会员");
	
	private int value;
	
	private String desc;
	
	private CareSendTypeEnmu(int value, String desc) {
		this.value = value;
		this.desc = desc;
	}
	
	public CareSendTypeEnmu getEnmuByVal(int value) {
		for(CareSendTypeEnmu enmu : CareSendTypeEnmu.values()) {
			if(enmu.getValue() == value) {
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
