package com.bithealth.taskMgrCore.enmu;


/**
 * 类名称: SyncStatusEnum  
 * 功能描述: 同步模块数据类型枚举 
 * 日期: 2016年12月21日 上午10:43:41 
 * 
 * @author 谢美团
 * @version  
 */
public enum ModuleTypeEnum {
	
	MEASURE(new Integer(1).byteValue(), "测量数据"),
	CARE(new Integer(2).byteValue(), "关注数据"),
	QUESTION(new Integer(3).byteValue(), "问卷数据");
	
	private Byte code;
	
	private String desc;

	public Byte getCode() {
		return code;
	}

	public void setCode(Byte code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	private ModuleTypeEnum(Byte code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public static ModuleTypeEnum getAccountType(Byte code) {
		for(ModuleTypeEnum accountType : ModuleTypeEnum.values()) {
			if(accountType.getCode() == code) {
				return accountType;
			}
		}
		return null;
	}
	
}
