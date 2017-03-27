package com.bithealth.centCore.care.enmu;


/**
 * 类名称: CareAuthorityEnmu  
 * 功能描述: 关注权限枚举类型
 * 日期: 2016年8月27日 下午4:38:25 
 * 
 * @author 谢美团
 * @version  
 */
public enum CareAuthorityEnmu {
	
	ALLOW_ITEM_1("1", "测量数据"),
	ALLOW_ITEM_2("2", "公卫服务数据"),
	ALLOW_ITEM_ALL("1,2", "全部允许查看权限"),
	RECEIVE_ITEM_1("1", "新的测量结果"),
	RECEIVE_ITEM_2("2", "有异常的测量结果"),
	RECEIVE_ITEM_3("3", "体检报告"),
	RECEIVE_ITEM_4("4", "随访服务"),
	RECEIVE_ITEM_ALL("1,3,4", "全部接收权限");
	
	private String value;
	
	private String desc;
	
	private CareAuthorityEnmu(String value, String desc) {
		this.value = value;
		this.desc = desc;
	}
	
	public CareAuthorityEnmu getEnmuByVal(int value) {
		for(CareAuthorityEnmu enmu : CareAuthorityEnmu.values()) {
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
