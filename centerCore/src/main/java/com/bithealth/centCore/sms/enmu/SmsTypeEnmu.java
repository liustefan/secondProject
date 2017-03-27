package com.bithealth.centCore.sms.enmu;


/**
 * 类名称: CareAuthorityEnmu  
 * 功能描述: 关注权限枚举类型
 * 日期: 2016年8月27日 下午4:38:25 
 * 
 * @author 谢美团
 * @version  
 */
public enum SmsTypeEnmu {
	

	CONTENT_TYPE_TEXT("1", "优先级-文本"),
	CONTENT_TYPE_VOICE("2", "优先级-语音");
	
	private String value;
	
	private String desc;
	
	private SmsTypeEnmu(String value, String desc) {
		this.value = value;
		this.desc = desc;
	}
	
	public SmsTypeEnmu getEnmuByVal(int value) {
		for(SmsTypeEnmu enmu : SmsTypeEnmu.values()) {
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
