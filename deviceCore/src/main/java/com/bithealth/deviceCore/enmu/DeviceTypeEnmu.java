package com.bithealth.deviceCore.enmu;



/**
 * 类名称: DeviceTypeEnmu  
 * 功能描述:设备枚举
 * 日期: 2017年1月16日 下午4:04:08 
 * 
 * @author 谢美团
 * @version  
 */
public enum DeviceTypeEnmu {
	
	Osbp("01", "血压计"),
	Obsr("02", "血糖仪");
	
	private String value;
	
	private String desc;
	
	private DeviceTypeEnmu(String value, String desc) {
		this.value = value;
		this.desc = desc;
	}
	
	public DeviceTypeEnmu getEnmuByVal(int value) {
		for(DeviceTypeEnmu enmu : DeviceTypeEnmu.values()) {
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
