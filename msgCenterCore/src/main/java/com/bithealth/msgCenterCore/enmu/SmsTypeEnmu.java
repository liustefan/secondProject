package com.bithealth.msgCenterCore.enmu;


/**
 * 类名称: CareAuthorityEnmu  
 * 功能描述: 关注权限枚举类型
 * 日期: 2016年8月27日 下午4:38:25 
 * 
 * @author 谢美团
 * @version  
 */
public enum SmsTypeEnmu {
	CONTENT_TYPE_TEXT(1, "文本"),
	CONTENT_TYPE_VOICE(2, "语音");
	
	private int value;
	
	private String desc;
	
	private SmsTypeEnmu(int value, String desc) {
		this.value = value;
		this.desc = desc;
	}
	
	public static SmsTypeEnmu getEnmuByVal(int value) {
		for(SmsTypeEnmu enmu : SmsTypeEnmu.values()) {
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
