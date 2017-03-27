/*
 * SingleAuditDetail.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-14 Created
 */
package com.bithealth.reportCore.template.model;

/**
 * 审核模板明细设置(RTS1)
 * 
 * @author ${user}
 * @version 1.0 2016-07-14
 */
public class SingleAuditDetail extends SingleAuditDetailKey {

    /**
     * 是否提交其他组
     */
    private String submitOther;
    /**
     * 标记
     */
    private String tag;

    public String getSubmitOther() {
        return submitOther;
    }
    public void setSubmitOther(String submitOther) {
        this.submitOther = submitOther;
    }
    public String getTag() {
        return tag;
    }
    public void setTag(String tag) {
        this.tag = tag;
    }
}