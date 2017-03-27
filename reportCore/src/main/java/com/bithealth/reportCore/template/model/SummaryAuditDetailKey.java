/*
 * SummaryAuditDetailKey.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-14 Created
 */
package com.bithealth.reportCore.template.model;

import com.bithealth.sdk.core.generic.GenericModel;

public class SummaryAuditDetailKey extends GenericModel {

    /**
     * 汇总报告审核模板
     */
    private Integer sumRepTempCode;
    /**
     * 审核级别
     */
    private Short auditLevel;

    public Integer getSumRepTempCode() {
        return sumRepTempCode;
    }
    public void setSumRepTempCode(Integer sumRepTempCode) {
        this.sumRepTempCode = sumRepTempCode;
    }
    public Short getAuditLevel() {
        return auditLevel;
    }
    public void setAuditLevel(Short auditLevel) {
        this.auditLevel = auditLevel;
    }
}