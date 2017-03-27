package com.bithealth.centCore.sms.enmu;


/**
 * 类名称: CareAuthorityEnmu  
 * 功能描述: 关注权限枚举类型
 * 日期: 2016年8月27日 下午4:38:25 
 * 
 * @author 谢美团
 * @version  
 */
public enum SmsEnmu {
	

	SMS_TYPE_REGISTER(1, "短信类型-会员注册","CaptchaTempletNo"),
	SMS_TYPE_FORGET_PASSWORD(2, "短信类型-忘记密码","CaptchaTempletNo"),
	SMS_TYPE_INVITE(3, "短信类型-邀请短信","CaptchaTempletNo"),
	SMS_TYPE_MODIDY(4, "短信类型-修改手机号","CaptchaTempletNo"),
	SMS_TYPE_TEST(5, "短信类型-测试短信","TestSMSTempletNo");
	
	private int value;
	
	private String desc;
	
	private String teamplateCode; //改类型短信使用的模板code
	
	
	private SmsEnmu(int value, String desc,String teamplateCode) {
		this.value = value;
		this.desc = desc;
		this.teamplateCode = teamplateCode;
	}
	
	public static SmsEnmu getEnmuByVal(int value) {
		for(SmsEnmu enmu : SmsEnmu.values()) {
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

	public String getTeamplateCode() {
		return teamplateCode;
	}

	public void setTeamplateCode(String teamplateCode) {
		this.teamplateCode = teamplateCode;
	}
	

}
