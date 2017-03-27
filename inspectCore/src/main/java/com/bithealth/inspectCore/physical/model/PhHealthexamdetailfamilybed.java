/*
 * PhHealthexamdetailfamilybed.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-06-27 Created
 */
package com.bithealth.inspectCore.physical.model;

import com.bithealth.sdk.core.generic.GenericModel;
import java.util.Date;

/**
 * 公共卫生_健康体检明细_家庭病床史表
 * 
 * @author ${user}
 * @version 1.0 2016-06-27
 */
public class PhHealthexamdetailfamilybed extends GenericModel {

    /**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么). 
	 */
	private static final long serialVersionUID = 862874978006091550L;
	/**
     * 记录ID
     */
    private Long logID;
    /**
     * 体检主ID，引用ph_healthexam
     */
    private Long HExamID;
    /**
     * 建床日期
     */
    private Date startDate;
    /**
     * 撤床日期
     */
    private Date endTime;
    /**
     * 原因
     */
    private String resson;
    /**
     * 医疗机构名称
     */
    private String institution;
    /**
     * 病案号
     */
    private String patientID;

    public Long getLogID() {
        return logID;
    }
    public void setLogID(Long logID) {
        this.logID = logID;
    }
    public Long getHExamID() {
        return HExamID;
    }
    public void setHExamID(Long HExamID) {
        this.HExamID = HExamID;
    }
    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public Date getEndTime() {
        return endTime;
    }
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
    public String getResson() {
        return resson;
    }
    public void setResson(String resson) {
        this.resson = resson;
    }
    public String getInstitution() {
        return institution;
    }
    public void setInstitution(String institution) {
        this.institution = institution;
    }
    public String getPatientID() {
        return patientID;
    }
    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }
}