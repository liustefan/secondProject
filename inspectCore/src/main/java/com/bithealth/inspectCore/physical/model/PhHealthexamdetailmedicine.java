/*
 * PhHealthexamdetailmedicine.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-06-27 Created
 */
package com.bithealth.inspectCore.physical.model;

import com.bithealth.inspectCore.model.DictEntity;

/**
 * 公共卫生_健康体检明细_主要用药情况表
 * 
 * @author ${user}
 * @version 1.0 2016-06-27
 */
public class PhHealthexamdetailmedicine extends DictEntity {

    /**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么). 
	 */
	private static final long serialVersionUID = -5833336697727978023L;
	/**
     * 记录ID
     */
    private Long logID;
    /**
     * 体检主ID，引用ph_healthexam
     */
    private Long HExamID;
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
     * 用药时间
     */
    private String drugUseTime;
    /**
     * 服药依从性，来源ph_dictitem
     */
    private Byte drugCompliance;
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
    public Long getHExamID() {
        return HExamID;
    }
    public void setHExamID(Long HExamID) {
        this.HExamID = HExamID;
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
    public String getDrugUseTime() {
        return drugUseTime;
    }
    public void setDrugUseTime(String drugUseTime) {
        this.drugUseTime = drugUseTime;
    }
    public Byte getDrugCompliance() {
        return drugCompliance;
    }
    public void setDrugCompliance(Byte drugCompliance) {
        this.drugCompliance = drugCompliance;
    }
    public String getRemarks() {
        return remarks;
    }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
	public String getDrugComplianceDes(){
		return convertStr("服药依从性", "健康体检_主要用药情况", this.drugCompliance);
	}
}