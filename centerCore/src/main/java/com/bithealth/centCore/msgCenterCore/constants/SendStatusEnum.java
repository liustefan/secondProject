
package com.bithealth.centCore.msgCenterCore.constants;


/**
 * 类名称: SendStatusEnum  
 * 功能描述: 消息发送状态枚举 
 * 日期: 2016年12月26日 上午11:39:46 
 * 
 * @author 谢美团
 * @version  
 */
public enum SendStatusEnum {
	TO_BE_SEND(1,"未发送"),
	SEND_SUCCESS(2,"发送成功"),
	SEND_FAIL(3,"发送失败");
	
	private byte type;
	private String value;
	
	SendStatusEnum(int type,String value){
		this.type = (byte) type;
		this.value = value;
	}
	
	public static SendStatusEnum findEnumByType(byte type){
		SendStatusEnum[] enums = SendStatusEnum.values();
		for(SendStatusEnum statusEnum : enums){
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
