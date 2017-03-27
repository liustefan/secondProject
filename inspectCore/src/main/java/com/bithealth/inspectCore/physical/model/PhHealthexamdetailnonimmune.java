/*
 * PhHealthexamdetailnonimmune.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-06-27 Created
 */
package com.bithealth.inspectCore.physical.model;

import com.bithealth.sdk.core.generic.GenericModel;
import java.util.Date;

/**
 * 公共卫生_健康体检明细_非免疫规划预防接种史表
 * 
 * @author ${user}
 * @version 1.0 2016-06-27
 */
public class PhHealthexamdetailnonimmune extends GenericModel {

    /**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么). 
	 */
	private static final long serialVersionUID = 6596499112857482359L;
	/**
     * 记录ID
     */
    private Long logID;
    /**
     * 体检主ID，引用ph_healthexam
     */
    private Long HExamID;
    /**
     * 接种名称
     */
    private String vaccinateName;
    /**
     * 接种日期
     */
    private Date vaccinateDate;
    /**
     * 医疗机构名称
     */
    private String institution;

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
    public String getVaccinateName() {
        return vaccinateName;
    }
    public void setVaccinateName(String vaccinateName) {
        this.vaccinateName = vaccinateName;
    }
    public Date getVaccinateDate() {
        return vaccinateDate;
    }
    public void setVaccinateDate(Date vaccinateDate) {
        this.vaccinateDate = vaccinateDate;
    }
    public String getInstitution() {
        return institution;
    }
    public void setInstitution(String institution) {
        this.institution = institution;
    }
}