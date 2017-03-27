/*
 * SummaryAuditDetail.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-14 Created
 */
package com.bithealth.reportCore.template.model;

/**
 * 汇总审核设置明细（SMS1）
 * 
 * @author ${user}
 * @version 1.0 2016-07-14
 */
public class SummaryAuditDetail extends SummaryAuditDetailKey {

    /**
     * 是否提交其他组
     */
    private String submitOther;

    public String getSubmitOther() {
        return submitOther;
    }
    public void setSubmitOther(String submitOther) {
        this.submitOther = submitOther;
    }
}