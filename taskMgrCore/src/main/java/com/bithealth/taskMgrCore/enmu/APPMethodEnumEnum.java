package com.bithealth.taskMgrCore.enmu;


/**
 * 类名称: SyncStatusEnum  
 * 功能描述: 同步模块数据类型枚举 
 * 日期: 2016年12月21日 上午10:43:41 
 * 
 * @author 谢美团
 * @version  
 */
public enum APPMethodEnumEnum {
	
	FINDMEMBERHEALTHFILE(1, "member/findMemberHealthFile","根据GUID查看基本档案"),
	MERGERBLOODSUGAR(2, "measure/mergerBloodSugar","上传血糖"),
	MERGERBLOODPRESSURE(3, "measure/mergerBloodPressure","上传血压"),
	MERGERMINI(4, "measure/mergerMini","上传迷你"),
	MERGERTHREEINONE(5, "measure/mergerThreeInOne","上传三合一");
	
	private int code;
	
	private String value;
	
	private String desc;


	private APPMethodEnumEnum(int code, String value, String desc) {
		this.code = code;
		this.value = value;
		this.desc = desc;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
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

	public static APPMethodEnumEnum getAccountType(int code) {
		for(APPMethodEnumEnum accountType : APPMethodEnumEnum.values()) {
			if(accountType.getCode() == code) {
				return accountType;
			}
		}
		return null;
	}
	
}
