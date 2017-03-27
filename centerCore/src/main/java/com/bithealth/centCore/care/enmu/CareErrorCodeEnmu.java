package com.bithealth.centCore.care.enmu;


/**
 * 类名称: CareAuthorityEnmu  
 * 功能描述: 关注权限枚举类型
 * 日期: 2016年8月27日 下午4:38:25 
 * 
 * @author 谢美团
 * @version  
 */
public enum CareErrorCodeEnmu {
	
	MEMBER_NOT_EXIST(101, "会员不存在"),
	CARE_ONESELF_ONT_ALLOW(102, "不能关联自己的账号"),
	ALREADY_FOLLOW(103, "你已关注该亲友，不可重复关注");
	
	private int value;
	
	private String desc;
	
	private CareErrorCodeEnmu(int value, String desc) {
		this.value = value;
		this.desc = desc;
	}
	
	public CareErrorCodeEnmu getEnmuByVal(int value) {
		for(CareErrorCodeEnmu enmu : CareErrorCodeEnmu.values()) {
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
