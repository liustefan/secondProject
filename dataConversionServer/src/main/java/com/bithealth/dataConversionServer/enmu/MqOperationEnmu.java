package com.bithealth.dataConversionServer.enmu;

public enum MqOperationEnmu {
	
	MQ_ZLJT_OPERATION_PARSEXML(1, 1,"zljyParseXml","QM命令：解析中联佳裕用户数XML字符串操作"),
	MQ_GOODDOCTOR_OPERATION_PARSEXML(2,2,"goodDoctorParseXml", "MQ命令：解析好医生用户数据XML字符串操作");
	
	private int index;
	
	private int source; //对应 CompanyConfigEnmu 枚举中的 公司 source

	private String operrationName;
	
	private String desc;
	
	
	public int getSource() {
		return source;
	}

	public void setSource(int source) {
		this.source = source;
	}

	private MqOperationEnmu(int index, int source, String operrationName,
			String desc) {
		this.index = index;
		this.source = source;
		this.operrationName = operrationName;
		this.desc = desc;
	}

	public static MqOperationEnmu getEnmuByIndex(int index) {
		for(MqOperationEnmu enmu : MqOperationEnmu.values()) {
			if(enmu.getIndex() == index) {
				return enmu;
			}
		}
		return null;
	}
	
	public static MqOperationEnmu getEnmuBySource(int source) {
		for(MqOperationEnmu enmu : MqOperationEnmu.values()) {
			if(enmu.getSource() == source) {
				return enmu;
			}
		}
		return null;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getOperrationName() {
		return operrationName;
	}

	public void setOperrationName(String operrationName) {
		this.operrationName = operrationName;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
