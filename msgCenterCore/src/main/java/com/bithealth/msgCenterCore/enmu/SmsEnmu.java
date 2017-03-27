package com.bithealth.msgCenterCore.enmu;


/**
 * 类名称: CareAuthorityEnmu  
 * 功能描述: 短信类型枚举类
 * 日期: 2016年8月27日 下午4:38:25 
 * 
 * @author 谢美团
 * @version  
 */
public enum SmsEnmu {
	All(0, "全部"),
	SMS_TYPE_REGISTER(1, "会员注册"),
	SMS_TYPE_FORGET_PASSWORD(2, "忘记密码"),
	SMS_TYPE_INVITE(3, "邀请短信"),
	SMS_TYPE_MODIDY(4, "修改手机号"),
	SMS_TYPE_TEST(5, "测试短信");
	
	private int value;
	
	private String desc;
	
	private SmsEnmu(int value, String desc) {
		this.value = value;
		this.desc = desc;
	}
	
	public static SmsEnmu getEnmuByVal(int value) {
		for(SmsEnmu enmu : SmsEnmu.values()) {
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
