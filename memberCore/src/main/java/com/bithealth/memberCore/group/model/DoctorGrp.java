/**
 * @PackageName:      com.bithealth.memberCore.group.model
 * @FileName:     DoctorGrp.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年6月28日 下午5:55:20  
 * 
 */
package com.bithealth.memberCore.group.model;

import java.io.Serializable;

/**
 * 类名称: DoctorGrp  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年6月28日 下午5:55:20 
 * 
 * @author liuhm
 * @version  
 */
public class DoctorGrp implements Serializable {

	private static final long serialVersionUID = 346679042409186720L;
	
	private Integer doctorGrpId;
	
	private String doctorGrpName;

	public Integer getDoctorGrpId() {
		return doctorGrpId;
	}

	public void setDoctorGrpId(Integer doctorGrpId) {
		this.doctorGrpId = doctorGrpId;
	}

	public String getDoctorGrpName() {
		return doctorGrpName;
	}

	public void setDoctorGrpName(String doctorGrpName) {
		this.doctorGrpName = doctorGrpName;
	}

}
