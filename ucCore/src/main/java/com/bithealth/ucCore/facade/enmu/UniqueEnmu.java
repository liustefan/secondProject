package com.bithealth.ucCore.facade.enmu;

/**
 * @ClassName:     OperationEnmu.java 
 * @Description:   验证一位性返回枚举
 * @author         谢美团  
 * @version        V1.0   
 * @Date           2016年7月2日 下午3:29:30
*****/
public enum UniqueEnmu {
	
	RESULT1(1, "基本资料或者账号唯一，可注册"),
	RESULT2(2, "基本资料或者账号已注册，但未成功通知web端"),
	RESULT3(3, "基本资料或者账号已存在，不能进行注册"),
	RESULT4(4, "必要参数为空");
	
	private int value;
	
	private String desc;
	
	private UniqueEnmu(int value, String desc) {
		this.value = value;
		this.desc = desc;
	}
	
	public UniqueEnmu getEnmuByVal(int value) {
		for(UniqueEnmu enmu : UniqueEnmu.values()) {
			if(enmu.getValue() == value) {
				return enmu;
			}
		}
		return null;
	}


	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	

}
