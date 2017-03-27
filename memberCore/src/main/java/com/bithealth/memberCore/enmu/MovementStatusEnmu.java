/**
 * @PackageName:      com.bithealth.memberCore.enmu
 * @FileName:     MovementStatusEnmu.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年11月28日 下午3:54:27  
 * 
 */
package com.bithealth.memberCore.enmu;

/**
 * 类名称: MovementStatusEnmu  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年11月28日 下午3:54:27 
 * 
 * @author liuhm
 * @version  
 */
public enum MovementStatusEnmu {
	affirm(1, "待确认"),
	agree(2, "已同意"),
	refuse(3, "已拒绝");
	
	private int status;
	
	private String desc;
	private MovementStatusEnmu(int status, String desc) {
		this.status = status;
		this.desc = desc;
	}
	
	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public String getDesc() {
		return desc;
	}
	
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
}
