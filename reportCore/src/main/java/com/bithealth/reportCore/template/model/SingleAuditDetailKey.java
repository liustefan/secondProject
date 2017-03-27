/*
 * SingleAuditDetailKey.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-14 Created
 */
package com.bithealth.reportCore.template.model;

import com.bithealth.sdk.core.generic.GenericModel;

public class SingleAuditDetailKey extends GenericModel {

    /**
     * 模板代码
     */
    private Integer tempCode;
    /**
     * 审核级别
     */
    private Short auditLevel;

    public Integer getTempCode() {
        return tempCode;
    }
    public void setTempCode(Integer tempCode) {
        this.tempCode = tempCode;
    }
    public Short getAuditLevel() {
        return auditLevel;
    }
    public void setAuditLevel(Short auditLevel) {
        this.auditLevel = auditLevel;
    }
}