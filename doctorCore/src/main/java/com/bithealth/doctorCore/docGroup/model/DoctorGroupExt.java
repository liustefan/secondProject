/**
 * @PackageName:      com.bithealth.doctorCore.docGroup.model
 * @FileName:     DoctorGroupExt.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年6月28日 下午4:56:46  
 * 
 */
package com.bithealth.doctorCore.docGroup.model;

import java.util.ArrayList;
import java.util.List;

import com.bithealth.doctorCore.doctor.model.Doctor;

/**
 * 类名称: DoctorGroupExt  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年6月28日 下午4:56:46 
 * 
 * @author liuhm
 * @version  
 */
public class DoctorGroupExt extends DoctorGroup {

	private static final long serialVersionUID = 1881110444352348923L;
	
	private List<MemGroup> memGrpList = new ArrayList<MemGroup>();
	
	private List<Doctor> doctorList = new ArrayList<Doctor>();

	public List<MemGroup> getMemGrpList() {
		return memGrpList;
	}

	public void setMemGrpList(List<MemGroup> memGrpList) {
		this.memGrpList = memGrpList;
	}

	public List<Doctor> getDoctorList() {
		return doctorList;
	}

	public void setDoctorList(List<Doctor> doctorList) {
		this.doctorList = doctorList;
	}
	
}
