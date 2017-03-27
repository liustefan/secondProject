/*
 * DocToGroup.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-06-23 Created
 */
package com.bithealth.doctorCore.docGroup.model;

import com.bithealth.doctorCore.doctor.model.Doctor;

/**
 * 医生分组明细(DGP1)
 * 
 * @author ${user}
 * @version 1.0 2016-06-23
 */
public class DocToGroup extends DocToGroupKey {

	private static final long serialVersionUID = 8278548543079091523L;
	/**
     * 组织代码
     */
    private Integer orgid;
    /**
     * 审核级别
     */
    private Short auditlevel;
    
    private DoctorGroup doctorGroup;
    
    private Doctor doctor;
    
    public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public DoctorGroup getDoctorGroup() {
		return doctorGroup;
	}
	public void setDoctorGroup(DoctorGroup doctorGroup) {
		this.doctorGroup = doctorGroup;
	}
	public Integer getOrgid() {
        return orgid;
    }
    public void setOrgid(Integer orgid) {
        this.orgid = orgid;
    }
    public Short getAuditlevel() {
        return auditlevel;
    }
    public void setAuditlevel(Short auditlevel) {
        this.auditlevel = auditlevel;
    }
}