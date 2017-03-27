package com.bithealth.reportCore.facade.enmu;


/**
 * 类名称: ReportStatusEnmu  
 * 功能描述: 报告状态枚举
 * 日期: 2016年7月29日 上午10:01:43 
 * 
 * @author 谢美团
 * @version  
 */
public enum ReportStatusEnmu {
	
	pending_audit("0", "报告待审核"),
	publish("1", "报告已发布"),
	haved_read("2", "报告已阅读");
	
	private String value;
	
	private String desc;
	
	private ReportStatusEnmu(String value, String desc) {
		this.value = value;
		this.desc = desc;
	}
	
	public ReportStatusEnmu getEnmuByVal(String value) {
		for(ReportStatusEnmu enmu : ReportStatusEnmu.values()) {
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
