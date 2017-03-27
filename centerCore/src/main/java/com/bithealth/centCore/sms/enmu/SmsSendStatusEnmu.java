package com.bithealth.centCore.sms.enmu;


/**
 * 类名称: CareAuthorityEnmu  
 * 功能描述: 关注发送枚举类型
 * 日期: 2016年8月27日 下午4:38:25 
 * 
 * @author 谢美团
 * @version  
 */
public enum SmsSendStatusEnmu {
	
	TO_BE_SEND((byte)1, "待发送"),
	HAVED_SEND((byte)2, "已发送"),
	SEND_SUCCESS((byte)3, "发送成功"),
	SEND_FAIL((byte)4, "发送失败");
	
	
	private byte value;
	
	private String desc;
	
	private SmsSendStatusEnmu(byte value, String desc) {
		this.value = value;
		this.desc = desc;
	}
	
	public SmsSendStatusEnmu getEnmuByVal(int value) {
		for(SmsSendStatusEnmu enmu : SmsSendStatusEnmu.values()) {
			if(enmu.getValue() == value) {
				return enmu;
			}
		}
		return null;
	}

	public byte getValue() {
		return value;
	}

	public void setValue(byte value) {
		this.value = value;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	

}
