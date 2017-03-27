/*
 * PhDiabetesdetailmedicine.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-06-28 Created
 */
package com.bithealth.inspectCore.inspect.model;

import com.bithealth.sdk.core.generic.GenericModel;

/**
 * 公共卫生_2型糖尿病随访明细_用药情况表
 * 
 * @author ${user}
 * @version 1.0 2016-06-28
 */
public class PhDiabetesdetailmedicine extends GenericModel {

    /**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么). 
	 */
	private static final long serialVersionUID = 3274441652237584605L;
	/**
     * 记录ID
     */
    private Long logID;
    /**
     * 糖尿病随访主ID，引用ph_diabetes
     */
    private Long diabetesID;
    /**
     * 药物名称
     */
    private String drugName;
    /**
     * 用法（口服、注射等）
     */
    private String drugUsage;
    /**
     * 频率（每日一次等）
     */
    private String drugFreq;
    /**
     * 用量
     */
    private String drugDosage;
    /**
     * 单位（mg、支等）
     */
    private String drugUnit;
    /**
     * 备注
     */
    private String remarks;

    public Long getLogID() {
        return logID;
    }
    public void setLogID(Long logID) {
        this.logID = logID;
    }
    public Long getDiabetesID() {
        return diabetesID;
    }
    public void setDiabetesID(Long diabetesID) {
        this.diabetesID = diabetesID;
    }
    public String getDrugName() {
        return drugName;
    }
    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }
    public String getDrugUsage() {
        return drugUsage;
    }
    public void setDrugUsage(String drugUsage) {
        this.drugUsage = drugUsage;
    }
    public String getDrugFreq() {
        return drugFreq;
    }
    public void setDrugFreq(String drugFreq) {
        this.drugFreq = drugFreq;
    }
    public String getDrugDosage() {
        return drugDosage;
    }
    public void setDrugDosage(String drugDosage) {
        this.drugDosage = drugDosage;
    }
    public String getDrugUnit() {
        return drugUnit;
    }
    public void setDrugUnit(String drugUnit) {
        this.drugUnit = drugUnit;
    }
    public String getRemarks() {
        return remarks;
    }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}