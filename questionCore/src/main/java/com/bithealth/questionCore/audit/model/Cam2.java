/*
 * Cam2.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-19 Created
 */
package com.bithealth.questionCore.audit.model;

import java.util.Date;

import com.bithealth.doctorCore.doctor.model.Doctor;

/**
 * 组合问卷审核结果（CAM2）
 * 
 * @author ${user}
 * @version 1.0 2016-07-19
 */
public class Cam2 extends Cam2Key {

    /**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么). 
	 */
	private static final long serialVersionUID = -2201437179709688172L;
	/**
     * 选项代码
     */
    private Short optId;
    /**
     * 功能代码
     */
    private Short funId;
    /**
     * 审核级别
     */
    private Short auditLevel;
    /**
     * 审核医生
     */
    private Integer docid;
    /**
     * 审核意见
     */
    private String auditDesc;
    /**
     * 审核时间
     */
    private Date auditTime;
    /**
     * 审核方式

0 ： 人工审核，1 ：批量审核
     */
    private String auditMode;
    /**
     * 诊断
     */
    private String diagnosis;
    
    private Doctor doctor;
    
    /**
     * base64图片
     */
    private String docSign;
    
    public Short getOptId() {
        return optId;
    }
    public void setOptId(Short optId) {
        this.optId = optId;
    }
    public Short getFunId() {
        return funId;
    }
    public void setFunId(Short funId) {
        this.funId = funId;
    }
    public Short getAuditLevel() {
        return auditLevel;
    }
    public void setAuditLevel(Short auditLevel) {
        this.auditLevel = auditLevel;
    }
    public Integer getDocid() {
        return docid;
    }
    public void setDocid(Integer docid) {
        this.docid = docid;
    }
    public String getAuditDesc() {
        return auditDesc;
    }
    public void setAuditDesc(String auditDesc) {
        this.auditDesc = auditDesc;
    }
    public Date getAuditTime() {
        return auditTime;
    }
    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }
    public String getAuditMode() {
        return auditMode;
    }
    public void setAuditMode(String auditMode) {
        this.auditMode = auditMode;
    }
    public String getDiagnosis() {
        return diagnosis;
    }
    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public String getDocSign() {
		return docSign;
	}
	public void setDocSign(String docSign) {
		this.docSign = docSign;
	}
    
}