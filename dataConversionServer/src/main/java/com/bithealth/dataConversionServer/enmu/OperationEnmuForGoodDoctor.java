package com.bithealth.dataConversionServer.enmu;


/**
 * @ClassName:     OperationEnmuForGoodDoctor.java 
 * @Description:   好医生操作方法枚举类
 * @author         谢美团  
 * @version        V1.0   
 * @Date           2016年7月2日 下午3:56:29
*****/
public enum OperationEnmuForGoodDoctor {
	
	ZLJY_OPERATION_1("1", "获取某段时间内更新过的个人基本资料信息"),
	ZLJY_OPERATION_2("2", "获取组织机构代码"),
	ZLJY_OPERATION_3("3", "上传健康体检信息"),
	ZLJY_OPERATION_4("4", "上传血压、脉率测量结果"),
	ZLJY_OPERATION_5("5", "上传血糖测量结果"),
	ZLJY_OPERATION_6("6", "上传糖尿病随访信息"),
	ZLJY_OPERATION_7("7", "上传高血压随访表");
	
	private String value;
	
	private String desc;
	
	private OperationEnmuForGoodDoctor(String value, String desc) {
		this.value = value;
		this.desc = desc;
	}
	
	public OperationEnmuForGoodDoctor getEnmuByVal(String value) {
		for(OperationEnmuForGoodDoctor enmu : OperationEnmuForGoodDoctor.values()) {
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
