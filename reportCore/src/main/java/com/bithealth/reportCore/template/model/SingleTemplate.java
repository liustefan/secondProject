/*
 * SingleTemplate.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-13 Created
 */
package com.bithealth.reportCore.template.model;

import java.util.ArrayList;
import java.util.List;

import com.bithealth.sdk.core.generic.GenericModel;

/**
 * 审核模板设置(ORTS)
 * 
 * @author ${user}
 * @version 1.0 2016-07-13
 */
public class SingleTemplate extends GenericModel {

    /**
     * 模板代码
     */
    private Integer tempCode;
    /**
     * 模板名称
     */
    private String tempName;
    /**
     * 功能代码
     */
    private Short funId;
    /**
     * 选项代码
     */
    private Short optId;
    /**
     * 设置说明
     */
    private String setDesc;
    /**
     * 最少记录数
     */
    private Short minRecords = 1;
    /**
     * 最少记录分布天数
     */
    private Short minDisDay;
    /**
     * 最大间隔天数
     */
    private Short maxMumDay = 1;
    /**
     * 是否审核
     */
    private String chTag;
    /**
     * 有效标记
     */
    private String valiTag = "T";
    /**
     * 组织代码
     */
    private Integer orgId;
    /**
     * 最长周期
     */
    private Short maxCycle;
    
    
    private String optName;
    
	/**
     * 单项模板审核明细列表
     */
    private List<SingleAuditDetail> singleAuditDetail;
    
	public String getOptName() {
		return optName;
	}
	public void setOptName(String optName) {
		this.optName = optName;
	}


	public List<SingleAuditDetail> getSingleAuditDetail() {
		return singleAuditDetail;
	}
	public void setSingleAuditDetail(List<SingleAuditDetail> singleAuditDetail) {
		this.singleAuditDetail = singleAuditDetail;
	}
	public Integer getTempCode() {
        return tempCode;
    }
    public void setTempCode(Integer tempCode) {
        this.tempCode = tempCode;
    }
    public String getTempName() {
        return tempName;
    }
    public void setTempName(String tempName) {
        this.tempName = tempName;
    }
    public Short getFunId() {
        return funId;
    }
    public void setFunId(Short funId) {
        this.funId = funId;
    }
    public Short getOptId() {
        return optId;
    }
    public void setOptId(Short optId) {
        this.optId = optId;
    }
    public String getSetDesc() {
        return setDesc;
    }
    public void setSetDesc(String setDesc) {
        this.setDesc = setDesc;
    }
    public Short getMinRecords() {
        return minRecords;
    }
    public void setMinRecords(Short minRecords) {
        this.minRecords = minRecords;
    }
    public Short getMinDisDay() {
        return minDisDay;
    }
    public void setMinDisDay(Short minDisDay) {
        this.minDisDay = minDisDay;
    }
    public Short getMaxMumDay() {
        return maxMumDay;
    }
    public void setMaxMumDay(Short maxMumDay) {
        this.maxMumDay = maxMumDay;
    }
    public String getChTag() {
        return chTag;
    }
    public void setChTag(String chTag) {
        this.chTag = chTag;
    }
    public String getValiTag() {
        return valiTag;
    }
    public void setValiTag(String valiTag) {
        this.valiTag = valiTag;
    }
    public Integer getOrgId() {
        return orgId;
    }
    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }
    public Short getMaxCycle() {
        return maxCycle;
    }
    public void setMaxCycle(Short maxCycle) {
        this.maxCycle = maxCycle;
    }
}