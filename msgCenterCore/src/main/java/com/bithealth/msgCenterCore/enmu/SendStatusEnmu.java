package com.bithealth.msgCenterCore.enmu;


/**
 * 类名称: CareAuthorityEnmu  
 * 功能描述: 关注权限枚举类型
 * 日期: 2016年8月27日 下午4:38:25 
 * 
 * @author 谢美团
 * @version  
 */
public enum SendStatusEnmu {
	
	SEND_STATUS_TO_BE_SEND(1, "待发送"),
	SEND_STATUS_HAVED_SEND(2, "已发送"),
	SEND_STATUS_SECCUSS(3, "发送成功"),
	SEND_STATUS_FAIL(4, "发送失败");
	
	private int value;
	
	private String desc;
	
	private SendStatusEnmu(int value, String desc) {
		this.value = value;
		this.desc = desc;
	}
	
	public static SendStatusEnmu getEnmuByVal(int value) {
		for(SendStatusEnmu enmu : SendStatusEnmu.values()) {
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
