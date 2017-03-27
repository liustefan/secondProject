package com.bithealth.dataConversionServer.enmu;

/**
 * @ClassName:     OperationEnmu.java 
 * @Description:   中联佳裕操作枚举
 * @author         谢美团  
 * @version        V1.0   
 * @Date           2016年7月2日 下午3:29:30
*****/
public enum OperationEnmu {
	
	ZLJY_OPERATION_1("1", "获取某段时间内更新过的个人基本资料信息"),
	ZLJY_OPERATION_2("2", "个人身份证号码查询个人基本信息"),
	ZLJY_OPERATION_3("3", "上传健康体检信息"),
	ZLJY_OPERATION_4("4", "身份证查询体检报告信息"),
	ZLJY_OPERATION_5("5", "上传血压、脉率测量结果"),
	ZLJY_OPERATION_6("6", "上传血糖测量结果"),
	ZLJY_OPERATION_7("7", "糖尿病随访信息上传"),
	ZLJY_OPERATION_8("8", "高血压随访表上传"),
	ZLJY_OPERATION_9("9", "获取机构数据"),
	ZLJY_OPERATION_10("10", "获取行政区域数据");
	
	private String value;
	
	private String desc;
	
	private OperationEnmu(String value, String desc) {
		this.value = value;
		this.desc = desc;
	}
	
	public OperationEnmu getEnmuByVal(String value) {
		for(OperationEnmu enmu : OperationEnmu.values()) {
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
