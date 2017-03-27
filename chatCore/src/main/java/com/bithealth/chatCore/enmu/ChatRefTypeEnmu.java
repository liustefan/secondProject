package com.bithealth.chatCore.enmu;



/**
 * 类名称: ChatRefTypeEnmu  
 * 功能描述: 聊天来源枚举类型
 * 日期: 2016年12月27日 下午4:38:25 
 * 
 * @author 柴仕富
 * @version  
 */
public enum ChatRefTypeEnmu {
 
//    [3.0]引用类型：1-健教，2-复诊，3-测量，4-单份问卷，5-组合问卷，6-高血压随访(公卫)，7-糖尿病随访(公卫)
	TYPE_HealthEdu(1, "健教"),
	TYPE_CPN(2, "复诊"),
	TYPE_MEASURE(3, "测量"),
	TYPE_SINGLE_PAPERS_PUBLIC(4, "单份问卷"),
	TYPE_COMBINATION_AUDIT_PUBLIC(5, "组合问卷"),
	TYPE_HYPERTENSION(6, "高血压随访(公卫)"),
	TYPE_DIABETES(7, "糖尿病随访(公卫)");
	
	   

	private byte type;
	private String value;
	
	ChatRefTypeEnmu(int type,String value){
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
	public static ChatRefTypeEnmu findEnumByType(int type){
		ChatRefTypeEnmu[] enums = ChatRefTypeEnmu.values();
		for(ChatRefTypeEnmu statusEnum : enums){
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
