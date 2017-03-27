/*
 * SummaryTemplate.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-13 Created
 */
package com.bithealth.reportCore.template.model;

import java.util.List;

import com.bithealth.sdk.core.generic.GenericModel;

/**
 * 汇总测量审核设置（OSMS）
 * 
 * @author ${user}
 * @version 1.0 2016-07-13
 */
public class SummaryTemplate extends GenericModel {

    /**
     * 汇总报告审核模板
     */
    private Integer sumRepTempCode;
    /**
     * 组织代码
     */
    private Integer orgId;
    /**
     * 模板名称
     */
    private String tempName;
    /**
     * 最大间隔天数
     */
    private Short maxMumDay;
    /**
     * 是否审核
     */
    private String chTag;
    /**
     * 有效标记
     */
    private String valiTag = "T";
    
    /**
     * 汇总审核明细列表
     */
    private List<SummaryAuditDetail> summaryAuditDetail;
    
    /**
     *  汇总报告中的周期是否大于其所关联的单项模板中的周期，T表示大于
     */
    private String warnFlag;
    
    
    private String isAddSingleTempalte;// T-已调价，F-未添加
     
    
    public String getIsAddSingleTempalte() {
		return isAddSingleTempalte;
	}
	public void setIsAddSingleTempalte(String isAddSingleTempalte) {
		this.isAddSingleTempalte = isAddSingleTempalte;
	}
	public String getWarnFlag() {
		return warnFlag;
	}
	public void setWarnFlag(String warnFlag) {
		this.warnFlag = warnFlag;
	}
	public List<SummaryAuditDetail> getSummaryAuditDetail() {
		return summaryAuditDetail;
	}
	public void setSummaryAuditDetail(List<SummaryAuditDetail> summaryAuditDetail) {
		this.summaryAuditDetail = summaryAuditDetail;
	}
	public Integer getSumRepTempCode() {
        return sumRepTempCode;
    }
    public void setSumRepTempCode(Integer sumRepTempCode) {
        this.sumRepTempCode = sumRepTempCode;
    }
    public Integer getOrgId() {
        return orgId;
    }
    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }
    public String getTempName() {
        return tempName;
    }
    public void setTempName(String tempName) {
        this.tempName = tempName;
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
}