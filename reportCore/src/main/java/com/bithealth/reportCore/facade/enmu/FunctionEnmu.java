package com.bithealth.reportCore.facade.enmu;

/**
 * @ClassName:     OperationEnmu.java 
 * @Description:   中联佳裕操作枚举
 * @author         谢美团  
 * @version        V1.0   
 * @Date           2016年7月2日 下午3:29:30
*****/
public enum FunctionEnmu {
	
	SINGLE_MEASURE(1, "单项测量"),
	SUMMARY_MEASURE(2, "汇总测量"),
	SINGLE_ANSWER(3, "单份答卷"),
	SUMMARY_ANSWER(4, "组合答卷");
	
	private int value;
	
	private String desc;
	
	private FunctionEnmu(int value, String desc) {
		this.value = value;
		this.desc = desc;
	}
	
	public FunctionEnmu getEnmuByVal(int value) {
		for(FunctionEnmu enmu : FunctionEnmu.values()) {
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
