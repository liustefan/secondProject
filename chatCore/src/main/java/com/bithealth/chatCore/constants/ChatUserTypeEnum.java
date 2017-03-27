/**
 * @PackageName:      com.bithealth.chatCore.enums
 * @FileName:     ChatUserTypeEnum.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      胡翔  * 
 * @version      V1.0  
 * @Createdate:  2016年6月29日 下午3:31:02  
 * 
 */
package com.bithealth.chatCore.constants;

/**
 * 类名称: ChatUserTypeEnum  
 * 功能描述: TODO 聊天用户类型枚举
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年6月29日 下午3:31:02 
 * 
 * @author 胡翔
 * @version  
 */
public enum ChatUserTypeEnum {
	DOCTOR(1,"医生"),MEMBER(2,"会员");
	private Byte type; 
	private String typeName;
	
	ChatUserTypeEnum(int type,String typeName){
		this.type = (byte) type;
		this.typeName = typeName;
	}
	/**
	 * @Title:findEnumByType 
	 * @Description:TODO(通过type值找到对应的用户类型枚举).  
	 * @author 胡翔
	 * @param type  查找的用户类型的值
	 * @return ChatUserTypeEnum 返回null或者想对应的值
	 */ 
	public static ChatUserTypeEnum findEnumByType(String type){
		ChatUserTypeEnum[] enums = ChatUserTypeEnum.values();
		for(ChatUserTypeEnum typeEnum : enums){
			if(typeEnum.type.toString().equals(type)){
				return typeEnum;
			}
		}
		return null;
	}
	public Byte getType() {
		return type;
	}
	public void setType(Byte type) {
		this.type = type;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	
}
