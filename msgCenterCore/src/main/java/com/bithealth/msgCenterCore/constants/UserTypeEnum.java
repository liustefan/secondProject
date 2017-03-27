/**
 * @PackageName:      com.bithealth.msgCenterCore.constants
 * @FileName:     SenderTypeEnum.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      胡翔  * 
 * @version      V1.0  
 * @Createdate:  2016年7月28日 下午4:38:32  
 * 
 */
package com.bithealth.msgCenterCore.constants;

/**
 * 类名称: UserTypeEnum  
 * 功能描述: TODO 消息用户类型  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月28日 下午4:38:32 
 * 
 * @author 胡翔
 * @version  
 */
public enum UserTypeEnum {
	SYSTEM(0,"系统"),
	DOCTOR(1,"医生"),
	MEMBER(2,"会员"),
	TAG(3,"tag");
	private byte type;
	private String value;
	
	UserTypeEnum(int type,String value){
		this.type = (byte) type;
		this.value = value;
	}
	/**
	 * 
	 * @Title:findEnumByStatus 
	 * @Description:TODO(通过发送消息类型获取枚举类型).  
	 * @author 胡翔
	 * @param type 消息状态值
	 * @return null or SenderTypeEnum
	 */
	public static UserTypeEnum findEnumByType(byte type){
		UserTypeEnum[] enums = UserTypeEnum.values();
		for(UserTypeEnum statusEnum : enums){
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
