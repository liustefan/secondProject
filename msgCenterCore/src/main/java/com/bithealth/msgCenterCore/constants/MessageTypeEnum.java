/**
 * @PackageName:      com.bithealth.msgCenterCore.constants
 * @FileName:     MessageTypeEnum.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      胡翔  * 
 * @version      V1.0  
 * @Createdate:  2016年7月27日 下午2:09:04  
 * 
 */
package com.bithealth.msgCenterCore.constants;

/**
 * 类名称: MessageTypeEnum  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月27日 下午2:09:04 
 * 
 * @author 胡翔
 * @version  
 */
public enum MessageTypeEnum {
	/**
	 * 1,温馨提示
	 */
	KINDLY_REMINDER(1,"温馨提示"),
	/**
	 * 2,我的咨询
	 */
	MY_CONSULT(2,"我的咨询"),
	/**
	 * 3，单项报告
	 */
	SINGLE_REPORT(3,"单项报告"),
	/**
	 * 4，汇总报告
	 */
	SUMMARY_REPORT(4,"汇总报告"),
	/**
	 * 5,单份答卷审核
	 */
	SINGLE_AUDIT_PAPERS(5,"单份答卷审核"),
	/**
	 * 6,组合答卷审核
	 */
	COMBINATION_AUDIT_PAPERS(6,"组合答卷审核"),
	/**
	 * 7，关注好友 
	 */
	ATTENTION_FRIENDS(7,"关注好友"),
	/**
	 * 8,健康资讯
	 */
	HEALTH_INFORMATION(8,"健康资讯"),
	/**
	 * 9,广告
	 */
	ADVERTISEMENT(9,"广告"),
	/**
	 * 10,测量数据
	 */
	MEASURED_DATA(10,"测量数据"),
	/**
	 * 11,体检随访
	 */
	PHYSICAL_EXAM(11,"体检随访"),
	/**
	 * 12,高血压随访
	 */
	HYPERTENSION_EXAM(12,"高血压随访"),
	/**
	 * 13,II型糖尿病随访
	 */
	DIABETES_EXAM(13,"II型糖尿病随访"),
	/**
	 * 14,II型糖尿病随访
	 */
	FRIENDS_DYNAMIC(14,"亲友动态"),
	/**
	 * 15,II型糖尿病随访
	 */
	BLOOD_PRESSURE(15,"血压测量"),
	/**
	 * 16,II型糖尿病随访
	 */
	BLOOD_SUGAR(16,"血糖测量"),
	/**
	 * 17,II型糖尿病随访
	 */
	ECG_MEASURE(17,"心电测量"),
	/**
	 * 18,II型糖尿病随访
	 */
	TRE_MEASURE(18,"3合1测量"),
	/**
	 * 19,单份问卷发放
	 */
	SINGLE_PAPERS_PUBLIC(19,"单份问卷发放"),
	/**
	 * 20,组合问卷发放
	 */
	COMBINATION_AUDIT_PUBLIC(20,"组合问卷发放");

	
	private byte type;
	private String value;
	
	MessageTypeEnum(int type,String value){
		this.type = (byte) type;
		this.value = value;
	}
	/**
	 * 
	 * @Title:findEnumByStatus 
	 * @Description:TODO(通过发送消息类型获取枚举类型).  
	 * @author 胡翔
	 * @param type 消息状态值
	 * @return null or MessageTypeEnum
	 */
	public static MessageTypeEnum findEnumByType(int type){
		MessageTypeEnum[] enums = MessageTypeEnum.values();
		for(MessageTypeEnum statusEnum : enums){
			if(statusEnum.type == type){
				return statusEnum;
			}
		}
		return null;
	}
	@Override
	public String toString() {
		return String.valueOf(this.type);
	}
	/**
	 * type.
	 *
	 * @return  the type 
	 */
	public byte getType() {
		return type;
	}
	/**
	 * type.
	 *
	 * @param   type    the type to set 
	 */
	public void setType(byte type) {
		this.type = type;
	}
	/**
	 * value.
	 *
	 * @return  the value 
	 */
	public String getValue() {
		return value;
	}
	/**
	 * value.
	 *
	 * @param   value    the value to set 
	 */
	public void setValue(String value) {
		this.value = value;
	}
	
}
